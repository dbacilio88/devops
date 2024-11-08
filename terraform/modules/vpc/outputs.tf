################################################################################
# VPC
################################################################################
/*
output "vpc_id" {
  value = aws_vpc.this.id
}

output "public_subnet_ids" {
  value = aws_subnet.public[*].id
}
output "private_subnet_ids" {
  value = aws_subnet.private[*].id
}

output "internet_gateway_id" {
  value = aws_internet_gateway.this.id
}

output "security_group_cluster_id" {
  value = aws_security_group.cluster.id
}

output "security_group_node_id" {
  value = aws_security_group.node.id
}

 */

output "vpc_id" {
  value = aws_vpc.this.id
}

output "public_subnet_ids" {
  value = aws_subnet.public[*].id
}

output "private_subnet_ids" {
  value = aws_subnet.private[*].id
}
output "security_group_id" {
  value = aws_security_group.security_group.id
}