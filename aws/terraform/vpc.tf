//create aws vpc name:vpc_bacsystem_net
resource "aws_vpc" "vpc_bacsystem_net" {
  cidr_block = var.cidr_block
  tags = {
    Name = "vpc_bacsystem_net"
  }
}