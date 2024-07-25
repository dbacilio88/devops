//create aws route table name:rt_bacsystem_net
resource "aws_route_table" "rt_bacsystem_net" {
  vpc_id = aws_vpc.vpc_bacsystem_net.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.igw_bacsystem_net.id
  }
  tags = {
    Name = "rt_bacsystem_net"
  }
}