# modules/ecr/variables.tf

variable "repository_name" {
  description = "The name of the ECR repository."
  type        = string
}

variable "image_tag_mutability" {
  description = "Enable tag immutability to prevent image tags from being overwritten by subsequent image pushes using the same tag. Disable tag immutability to allow image tags to be overwritten."
  type        = string
  default     = "MUTABLE"
}
variable "image_scanning_configuration" {
  description = "Enable scan on push to have each image automatically scanned after being pushed to a repository. If disabled, each image scan must be manually started to get scan results."
  type        = bool
  default     = false
}

variable "tags" {
  description = "Tags to apply to the repository."
  type = map(string)
  default = {}
}
