output "vpc_id" {
  value = aws_vpc.this.id
}

output "subnet_public_ids" {
  value = ""
}

output "subnet_private_ids" {
  value = ""
}

output "internet_gateway_id" {
  value = ""
}

output "nat_gateway_ids" {
  value = ""
}


################################################################################
# Security Group
################################################################################
/*
output "endpoints" {
  description = "Array containing the full resource object and attributes for all endpoints created"
  value       = aws_vpc_endpoint.this
}
output "security_group_arn" {
  description = "Amazon Resource Name (ARN) of the security group"
  value = try(aws_security_group.this[0].arn, null)
}

output "security_group_id" {
  description = "ID of the security group"
  value = try(aws_security_group.this[0].id, null)
}

 */