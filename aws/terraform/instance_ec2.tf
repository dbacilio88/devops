resource "aws_instance" "public_bacsystem_ssh" {
  count         = 3
  subnet_id     = aws_subnet.pub_sub_bacsystem_net[count.index].id
  ami           = var.ec2_ami
  instance_type = var.ec2_type
  key_name      = data.aws_key_pair.key.key_name
  vpc_security_group_ids = [
    aws_security_group.sg_public_bacsystem_net.id
  ]
  tags = {
    Name = "public_bacsystem_ssh-${count.index + 1}"
  }
}