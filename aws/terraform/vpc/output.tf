output "ec2_public_ip" {
  description = "Ip public instance"
  value       = aws_instance.public_instance.public_ip
}