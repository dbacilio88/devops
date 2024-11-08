# Obtén las zonas de disponibilidad disponibles en la región
/*
data "aws_availability_zones" "available" {}

# Definición de valores locales
locals {
  name                 = "utec-${basename(path.cwd)}"
  region               = "us-east-1"
  base_cidr = "172.16.0.0/16"
  # Número de subredes que queremos crear
  num_subnets_public   = 3
  num_subnets_private  = 3
  num_subnets_total    = 6
  subnet_prefix_length = 4
  # Selecciona las primeras 3 zonas de disponibilidad
  //azc = slice(data.aws_availability_zones.available.names, local.num_subnets_total)
  # Verifica las zonas de disponibilidad disponibles
  available_zones      = data.aws_availability_zones.available.names
  zone_count = length(local.available_zones)
  # Selecciona las zonas de disponibilidad necesarias

  azc = slice(data.aws_availability_zones.available.names, 0, min(local.num_subnets_total, local.zone_count))

  # Calcula el CIDR de cada subred usando cidrsubnet
  # public_subnet_cidr = [
  #   for i in range(local.num_subnets_public) :cidrsubnet(local.base_cidr, local.subnet_prefix_length, i)
  # ]

  # Calcula el CIDR de cada subred usando cidrsubnet
  subnet_cidr        = [for i in range(local.num_subnets_total) : cidrsubnet(local.base_cidr, 4, i)]
  subnet_public_cidr = slice(local.subnet_cidr, 0, local.num_subnets_public)
  #private_subnet_cidr = [
  #  for i in range(local.num_subnets_private) :cidrsubnet(local.base_cidr, local.subnet_prefix_length, i)
  #]
  subnet_private_cidr = slice(local.subnet_cidr, local.num_subnets_public, local.num_subnets_total)
  # Genera zonas de disponibilidad dinámicamente a partir de las zonas seleccionadas
  availability_zones = [for i in range(local.num_subnets_public) : local.azc[i % length(local.azc)]]

  subnet_names = [for i in range(local.num_subnets_total) : "${local.name}-subnet-${i}"]
  tags = {
    Example    = local.name
    GithubRepo = "terraform-aws-modules"
    GithubOrg  = "terraform-aws-modules"
  }
}

 */

locals {
  vpc_name = "utec-${basename(path.cwd)}"
  region   = "us-east-1"
}

################################################################################
# VPC Module
################################################################################
module "vpc" {
  source = "../../modules/vpc"

  vpc_cidr             = "172.16.0.0/16"
  vpc_name             = local.vpc_name
  public_subnet_count  = 3
  private_subnet_count = 3
}