//create aws internet gateway name:igw_bacsystem_net
resource "aws_internet_gateway" "igw_bacsystem_net" {
  vpc_id = aws_vpc.vpc_bacsystem_net.id
  tags = {
    Name = "igw_bacsystem_net"
  }
}