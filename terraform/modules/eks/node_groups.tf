resource "aws_eks_node_group" "this" {
  for_each        = var.node_groups
  cluster_name    = aws_eks_cluster.eks_cluster.name
  node_group_name = each.key
  node_role_arn   = aws_iam_role.node_iam_role[each.key].arn
  subnet_ids      = var.subnet_ids
  scaling_config {
    desired_size = each.value.desired_capacity
    max_size     = each.value.max_capacity
    min_size     = each.value.min_capacity
  }

  capacity_type = each.value.capacity_type

  instance_types = each.value.instance_types
  tags = {
    Name = each.key
  }
  depends_on = [aws_eks_cluster.eks_cluster]
}