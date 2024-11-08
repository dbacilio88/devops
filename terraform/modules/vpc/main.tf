################################################################################
# LOCALS
################################################################################
locals {
  az_count = length(data.aws_availability_zones.available.names)
  # Define the number of subnets for public and private
  public_subnet_count = var.public_subnet_count
  private_subnet_count = var.private_subnet_count
  # Generate CIDR blocks for public subnets dynamically
  public_subnet_cidr = [
    for i in range(local.public_subnet_count) : cidrsubnet(var.vpc_cidr, 8, i)
  ]
  # Generate CIDR blocks for private subnets dynamically
  private_subnet_cidr = [
    for i in range(local.private_subnet_count) : cidrsubnet(var.vpc_cidr, 8, local.public_subnet_count+i)
  ]


  public_subnets = [
    for i, cidr in local.public_subnet_cidr : {
      cidr_block        = cidr
      availability_zone = data.aws_availability_zones.available.names[i%local.az_count]
    }
  ]
  private_subnets = [
    for i, cidr in local.private_subnet_cidr : {
      cidr_block        = cidr
      availability_zone = data.aws_availability_zones.available.names[i%local.az_count]
    }
  ]
}
################################################################################
# DATA
################################################################################
data "aws_availability_zones" "available" {}
################################################################################
# VPC
################################################################################
resource "aws_vpc" "this" {
  cidr_block           = var.vpc_cidr
  enable_dns_hostnames = true
  enable_dns_support   = true
  tags = {
    Name = var.vpc_name
  }
}
################################################################################
# Internet Gateway
################################################################################
resource "aws_internet_gateway" "this" {
  vpc_id = aws_vpc.this.id
  tags = {
    Name = "${var.vpc_name}-igw"
  }
}
################################################################################
# Public Subnets
################################################################################
resource "aws_subnet" "public" {
  count = length(local.public_subnets)
  vpc_id                  = aws_vpc.this.id
  cidr_block              = local.public_subnets[count.index].cidr_block
  availability_zone       = local.public_subnets[count.index].availability_zone
  map_public_ip_on_launch = true
  tags = {
    Name = "${var.vpc_name}-subnet-public-${count.index}"
  }
}
################################################################################
# Private Subnets
################################################################################
resource "aws_subnet" "private" {
  count = length(local.private_subnets)
  vpc_id                  = aws_vpc.this.id
  cidr_block              = local.private_subnets[count.index].cidr_block
  availability_zone       = local.private_subnets[count.index].availability_zone
  map_public_ip_on_launch = true
  tags = {
    Name = "${var.vpc_name}-subnet-private-${count.index}"
  }
}
################################################################################
# Table route public
################################################################################
resource "aws_route_table" "public" {
  vpc_id = aws_vpc.this.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.this.id
  }
  tags = {
    Name = "${var.vpc_name}-public-rt"
  }
}
################################################################################
# Table route associate public
################################################################################
resource "aws_route_table_association" "public" {
  count = length(aws_subnet.public)
  subnet_id      = aws_subnet.public[count.index].id
  route_table_id = aws_route_table.public.id
}
################################################################################
# Table route private
################################################################################
resource "aws_route_table" "private" {
  vpc_id = aws_vpc.this.id
  tags = {
    Name = "${var.vpc_name}-private-rt"
  }
}
################################################################################
# Table route associate private
################################################################################
resource "aws_route_table_association" "private" {
  count = length(aws_subnet.private)
  subnet_id      = aws_subnet.private[count.index].id
  route_table_id = aws_route_table.private.id
}


################################################################################
# Security group cluster
################################################################################

resource "aws_security_group" "security_group" {
  name        = "${var.vpc_name}-sg"
  description = "Allow TLS inbound traffic and all outbound traffic"
  vpc_id      = aws_vpc.this.id

  ingress {
    from_port = 443
    to_port   = 443
    protocol  = "tcp"
  }

  ingress {
    description = "HTTP over Internet"
    from_port   = 0
    to_port     = 0
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    cidr_blocks = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name = "${var.vpc_name}-sg"
  }
}
/*
################################################################################
# Security group node
################################################################################
resource "aws_security_group" "node" {
  name        = "${var.vpc_name}-node-sg"
  description = "Security group for EKS nodes"
  vpc_id      = aws_vpc.this.id

  ingress {
    from_port = 22
    to_port   = 22
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 1025
    to_port   = 65535
    protocol  = "tcp"
    security_groups = [aws_security_group.cluster.id]
  }

  egress {
    from_port = 0
    to_port   = 0
    protocol  = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "${var.vpc_name}-node-sg"
  }
}


 */