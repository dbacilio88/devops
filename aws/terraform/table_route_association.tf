//create aws route table association name:rta_bacsystem_net
resource "aws_route_table_association" "rta_bacsystem_net" {
  count = 3
  #subnet_id      = aws_subnet.pub_sub_bacsystem_net.id
  subnet_id      = aws_subnet.pub_sub_bacsystem_net[count.index].id
  route_table_id = aws_route_table.rt_bacsystem_net.id
}