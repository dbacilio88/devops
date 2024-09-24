data "aws_availability_zones" "zones_bacsystem" {}


//create aws subnet name:pub_sub_bacsystem_net
resource "aws_subnet" "pub_sub_bacsystem_net" {
  #count = length(data.aws_availability_zones.zones_bacsystem.names)
  count      = 3
  vpc_id     = aws_vpc.vpc_bacsystem_net.id
  cidr_block = cidrsubnet(aws_vpc.vpc_bacsystem_net.cidr_block, 8, count.index + 1)
  //cidr_block              = var.cidr_block_subnet_public
  map_public_ip_on_launch = true
  availability_zone       = element(data.aws_availability_zones.zones_bacsystem.names, count.index)
  tags = {
    Name = "pub_sub_bacsystem_net"
  }
}
