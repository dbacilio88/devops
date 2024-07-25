variable "tags" {
  description = "tags project"
  type = map(string)
}

variable "cidr_block" {
  description = "cidr block"
  nullable    = false
  sensitive   = true
  type        = string
  default     = "10.10.0.0/16"
}

variable "cidr_block_subnet_public" {
  default     = "10.10.0.0/20"
  description = "cidr_block_subnet_public"
  nullable    = false
  type        = string
}
variable "cidr_block_subnet_private" {
  default     = "10.10.128.0/20"
  description = "cidr_block_subnet_private"
  nullable    = false
  type        = string
}

variable "ingress_cidr" {
  default     = "0.0.0.0/0"
  description = "ingress_cidr"
  type        = string
}
variable "egress_cidr" {
  default     = "0.0.0.0/0"
  description = "ingress_cidr"
  type        = string
}

variable "ec2_ami" {
  default = "ami-0427090fd1714168b"
  type    = string
}
variable "ec2_type" {
  default = "t2.micro"
  type    = string
}