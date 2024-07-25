data "aws_key_pair" "key" {
  key_name = "instance_aws"
  depends_on = [
    aws_key_pair.kp_bacsystem_key
  ]
}