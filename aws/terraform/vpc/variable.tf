// la mas adoptada y usada:
variable "virginia_cidr" {
  description = "CIDR Virginia"
  type        = string
  default     = "10.10.0.0/16"
  sensitive   = true
}

variable "public_subnet" {
  description = "public subnet"

}
variable "private_subnet" {
  description = "private subnet"
}

variable "subnets" {
  description = "list subnets"
  type = list(string)
}

variable "tags" {
  description = "tags project"

  type = map(string)
}