//create aws security group association name:sg_public_bacsystem_net
resource "aws_security_group" "sg_public_bacsystem_net" {
  name        = "sg_public_bacsystem_net"
  description = "Allow TLS inbound traffic and all outbound traffic"
  vpc_id      = aws_vpc.vpc_bacsystem_net.id

  ingress {
    description = "SSF over Internet"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = [var.ingress_cidr]
  }

  ingress {
    description = "HTTP over Internet"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = [var.ingress_cidr]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = [var.egress_cidr]
    ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name = "sg_public_bacsystem_net"
  }
}