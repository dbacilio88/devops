resource "aws_vpc" "vpc_virginia" {
  cidr_block = var.virginia_cidr
  tags = {
    "Name" = "vpc_virginia"
  }
}


resource "aws_subnet" "public_subnet" {
  vpc_id                  = aws_vpc.vpc_virginia.id
  cidr_block              = var.subnets[0]
  map_public_ip_on_launch = true
  tags = {
    "Name" = "public_subnet_temp"
  }

}
resource "aws_subnet" "private_subnet" {
  vpc_id     = aws_vpc.vpc_virginia.id
  cidr_block = var.subnets[1]
  tags = {
    "Name" = "private_subnet_temp"
  }
  depends_on = [
    aws_subnet.public_subnet
  ]
}



//variables de entorno: TF_VAR_virginia_cidr=value
//variables de entorno: terraform plan -var virginia_cidr="value"
//borrar variables: unset TF_VAR_virginia_cidr