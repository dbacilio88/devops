################################################################################
# EKS
################################################################################
resource "aws_eks_cluster" "eks_cluster" {
  name     = var.cluster_name
  role_arn = aws_iam_role.eks_iam_role.arn
  version  = var.cluster_version

  vpc_config {
    subnet_ids              = var.subnet_ids
    endpoint_public_access  = var.endpoint_public_access
    endpoint_private_access = var.endpoint_private_access
    security_group_ids      = var.security_group_ids
  }


  depends_on = [
    aws_iam_role_policy_attachment.eks_cluster_policy
  ]



  tags = merge({ "Name" = var.cluster_name })
}
################################################################################
# AWS EKS ADDON
################################################################################
resource "aws_eks_addon" "eks_addon" {
  for_each      = var.cluster_addons
  cluster_name  = aws_eks_cluster.eks_cluster.name
  addon_name    = each.key
  addon_version = each.value.version != "" ? each.value.version : null
  depends_on = [
    aws_eks_cluster.eks_cluster
  ]
}