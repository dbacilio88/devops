output "vpc_id" {
  description = "The ID of the VPC"
  value       = module.vpc.vpc_id
}

/*
output "azc" {
  value = local.azc
}

 */
/*
output "availability_zones" {
  value = local.azc
}

 */
output "public_subnet_ids" {
  value = module.vpc.public_subnet_ids
}

output "private_subnet_ids" {
  value = module.vpc.private_subnet_ids
}
/*
output "internet_gateway_id" {
  value = module.vpc.internet_gateway_id
}

 */