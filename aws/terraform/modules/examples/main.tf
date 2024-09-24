module "vpc" {
  source   = "../vpc"
  vpc_cidr = "10.0.0.0/16"
  vpc_name = "vpc_name"
  vpc_subnet_public = ["10.0.1.0/24", "10.0.3.0/24", "10.0.5.0/24"]
  vpc_subnet_private = ["10.0.2.0/24", "10.0.4.0/24", "10.0.6.0/24"]
  availability_zones = ["us-east-1", "us-east-2"]
}


/*
  name = local.name
  cidr = "10.0.0.0/16"

  azs = ["eu-west-1a", "eu-west-1b", "eu-west-1c"]
  private_subnets = ["10.0.1.0/24", "10.0.2.0/24", "10.0.3.0/24"]
  public_subnets = ["10.0.101.0/24", "10.0.102.0/24", "10.0.103.0/24"]

  enable_nat_gateway = true
  enable_vpn_gateway = true

  tags = {
    Terraform   = "true"
    Environment = "dev"
  }

 */