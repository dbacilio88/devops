resource "aws_eks_cluster" "eks_bacsystem" {
  name     = var.cluster_name
  role_arn = aws_iam_role.iam_cluster_bacsystem.arn
  version  = "1.30"
  vpc_config {
    subnet_ids = aws_subnet.pub_sub_bacsystem_net[*].id
  }
  depends_on = [
    aws_iam_role_policy_attachment.policy_bacsystem_cluster
  ]
  tags = {
    Name = "eks_bacsystem"
  }
}


resource "aws_eks_node_group" "eks_node_bacsystem" {
  cluster_name    = aws_eks_cluster.eks_bacsystem.name
  node_group_name = "eks_node_bacsystem"
  node_role_arn   = aws_iam_role.iam_node_group_bacsystem.arn
  subnet_ids      = aws_subnet.pub_sub_bacsystem_net[*].id

  scaling_config {
    desired_size = 1
    max_size     = 2
    min_size     = 1
  }

  capacity_type = "ON_DEMAND"

  depends_on = [
    aws_eks_cluster.eks_bacsystem
  ]
}