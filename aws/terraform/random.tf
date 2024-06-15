# DRY: don't repeat yourself
resource "random_string" "random" {
  count   = 100
  length  = 4
  special = false
  #override_special = "/@£$"
  upper = false
  #number = deprecate
  numeric = false
}