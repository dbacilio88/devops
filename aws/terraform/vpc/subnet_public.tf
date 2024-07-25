//create aws subnet name:pub_sub_bacsystem_net
resource "aws_subnet" "pub_sub_bacsystem_net" {
  vpc_id                  = aws_vpc.vpc_bacsystem_net.id
  cidr_block              = var.cidr_block_subnet_public
  map_public_ip_on_launch = true
  tags = {
    Name = "pub_sub_bacsystem_net"
  }
}
