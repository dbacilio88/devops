output "ec2_public_ips" {
  description = "Ip public instance ssh"
  value       = aws_instance.public_bacsystem_ssh[*].public_ip
}


output "eks_endpoint" {
  value = aws_eks_cluster.eks_bacsystem.endpoint
}

output "eks_name" {
  value = aws_eks_cluster.eks_bacsystem.name
}

output "kube_config_command" {
  value = aws_eks_cluster.eks_bacsystem.outpost_config
}