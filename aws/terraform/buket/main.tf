//pueden crear 10 recursos en paralelo
// hashicorp

# Resources aws_s3_bucket
resource "aws_s3_bucket" "proveedores" {
  count = 10
  bucket = "proveedores-${random_string.random[count.index].id}"
  //Siempre es recomendable con etiquetas
  tags = {
    Owner       = "cbacilio"
    Environment = "Dev"
    Office      = "Developer"
  }
}
# DRY: don't repeat yourself
resource "random_string" "random" {
  count   = 10
  length  = 4
  special = false
  #override_special = "/@£$"
  upper = false
  #number = deprecate
  numeric = false
}


//es recomendable hacer un plan: terraform plan --out=s3.plan
