//create aws subnet name:pvt_sub_bacsystem_net
resource "aws_subnet" "pvt_sub_bacsystem_net" {
  vpc_id     = aws_vpc.vpc_bacsystem_net.id
  cidr_block = var.cidr_block_subnet_private
  depends_on = [
    aws_subnet.pub_sub_bacsystem_net
  ]
  tags = {
    Name = "pvt_sub_bacsystem_net"
  }
}