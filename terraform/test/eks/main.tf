locals {
  vpc_name        = "utec-${basename(path.cwd)}"
  eks_name        = "utec-${basename(path.cwd)}"
  ecr_name        = "api-utec-customer-microservice"
  region          = "us-east-1"
  cluster_version = "1.30"
}

################################################################################
# VPC Module
################################################################################
module "vpc" {
  source = "../../modules/vpc"

  vpc_cidr             = "172.16.0.0/16"
  vpc_name             = local.vpc_name
  public_subnet_count  = 3
  private_subnet_count = 3
}

module "eks" {
  source = "../../modules/eks"


  cluster_name = local.eks_name
  subnet_ids   = module.vpc.public_subnet_ids
  security_group_ids = [module.vpc.security_group_id]
  node_groups = {
    "node_groups" = {
      desired_capacity = 1
      min_capacity     = 1
      max_capacity     = 2
      instance_types = ["t3.medium"]
      capacity_type    = "ON_DEMAND"
    }
  }
  cluster_addons = {
    "coredns" = {
      most_recent = true
    },
    "kube-proxy" = {
      most_recent = true
    },
    "vpc-cni" = {
      most_recent = true
    }
    "eks-pod-identity-agent" = {
      most_recent = true
    }
  }
  cluster_version = local.cluster_version
}

################################################################################
# ECR Module
################################################################################
module "ecr" {
  source = "../../modules/ecr"

  repository_name              = local.ecr_name
  image_scanning_configuration = true
  image_tag_mutability         = "MUTABLE"
  tags = {
    Environment = "Test"
    Project     = "utec-project"
  }
}