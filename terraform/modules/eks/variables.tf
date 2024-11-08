# modules/eks/variables.tf

variable "cluster_name" {
  description = "The name of the EKS cluster."
  type        = string
}

variable "cluster_version" {
  description = "The version of the EKS cluster."
  type        = string
}

variable "subnet_ids" {
  description = "The IDs of the subnets for the EKS cluster."
  type = list(string)
}
variable "security_group_ids" {
  description = "The IDs of the security group for the EKS cluster."
  type = list(string)
}

variable "endpoint_public_access" {
  description = "Whether to enable public access to the EKS cluster endpoint."
  type        = bool
  default     = true
}

variable "endpoint_private_access" {
  description = "Whether to enable private access to the EKS cluster endpoint."
  type        = bool
  default     = true
}


variable "cluster_addons" {
  description = "A map of EKS cluster addons to configure."
  type = map(object({
    most_recent = bool
    version = optional(string)
  }))
  default = {
    coredns = {
      most_recent = true
    },
    kube_proxy = {
      most_recent = true
    },
    vpc_cni = {
      most_recent = true
    }
    identity_agent = {
      most_recent = true
    }
  }
}

variable "node_groups" {
  description = "A map of node group configurations for the EKS cluster."
  type = map(object({
    desired_capacity = number
    max_capacity     = number
    min_capacity     = number
    capacity_type    = string
    instance_types = list(string)
  }))
}
