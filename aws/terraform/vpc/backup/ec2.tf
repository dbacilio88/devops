//ami-08a0d1e16fc3f61ea
resource "aws_instance" "public_instance" {
  ami           = var.ec2_specs.ami
  instance_type = var.ec2_specs.instance_type
  subnet_id     = aws_subnet.public_subnet.id
  key_name      = data.aws_key_pair.key.key_name
  user_data     = file("user_data.sh")

  tags = {
    "Name" = "public_instance"
  }

  #
  # lifecycle {
  #create_before_destroy = true
  #prevent_destroy = true
  #}


  vpc_security_group_ids = [aws_security_group.sg_public_instance.id]

  provisioner "local-exec" {
    command = "echo instance create con Ip ${aws_instance.public_instance.public_ip} >> datas_instance.txt"
  }

  provisioner "local-exec" {
    when    = destroy
    command = "echo instance destroy con Ip ${self.public_ip} >> data_instance.txt"
  }
  /*
    provisioner "remote-exec" {
      inline = [
        "echo 'hello-world' >  ~/saludos.txt"
      ]
      connection {
        type = "ssh"
        host = self.public_ip
        user = "ec2-user"
        private_key = file("../secret/cbacilio-key.pem")
      }
    }*/
}
## chmod 400 file
#ssh -i ../secret/cbacilio-key-pen ec2-user@10.20.1.229
