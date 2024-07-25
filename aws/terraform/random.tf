# DRY: don't repeat yourself
resource "random_string" "random" {
  count   = 1
  length  = 4
  special = false
  #override_special = "/@£$"
  upper = false
  #number = deprecate
  numeric = false
}