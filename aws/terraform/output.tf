output "ec2_public_ips" {
  description = "Ip public instance ssh"
  value       = aws_instance.public_bacsystem_ssh.public_ip
}