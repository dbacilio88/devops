################################################################################
# DATA FOR EKS CLUSTER
################################################################################
data "aws_iam_policy_document" "aws_iam_policy_data_eks" {
  statement {
    effect = "Allow"

    principals {
      type = "Service"
      identifiers = ["eks.amazonaws.com"]
    }

    actions = ["sts:AssumeRole"]
  }
}
################################################################################
# ROLE FOR EKS CLUSTER
################################################################################
resource "aws_iam_role" "eks_iam_role" {
  name               = "${var.cluster_name}-eks-role"
  assume_role_policy = data.aws_iam_policy_document.aws_iam_policy_data_eks.json

  tags = {
    Name = "${var.cluster_name}-eks-role"
  }
}
################################################################################
# POLICY_ATTACHMENT CLUSTER
################################################################################
resource "aws_iam_role_policy_attachment" "eks_service_policy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSServicePolicy"
  role       = aws_iam_role.eks_iam_role.name
}
resource "aws_iam_role_policy_attachment" "eks_cluster_policy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy"
  role       = aws_iam_role.eks_iam_role.name
}
resource "aws_iam_role_policy_attachment" "eks_vpc_resources_policy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSVPCResourceController"
  role       = aws_iam_role.eks_iam_role.name
}


################################################################################
# DATA FOR EKS NODE
################################################################################
data "aws_iam_policy_document" "aws_iam_policy_data_ec2" {
  statement {
    effect = "Allow"
    principals {
      type = "Service"
      identifiers = ["ec2.amazonaws.com"]
    }

    actions = ["sts:AssumeRole"]
  }
}

################################################################################
# ROLE FOR EKS CLUSTER NODE
################################################################################
resource "aws_iam_role" "node_iam_role" {
  for_each           = var.node_groups
  name               = "${var.cluster_name}-node-role"
  assume_role_policy = data.aws_iam_policy_document.aws_iam_policy_data_ec2.json

  tags = {
    Name = "${var.cluster_name}-node-role"
  }
}
################################################################################
# POLICY_ATTACHMENT NODE
################################################################################
resource "aws_iam_role_policy_attachment" "eks_worker_node_policy" {
  for_each   = var.node_groups
  role       = aws_iam_role.node_iam_role[each.key].name
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSWorkerNodePolicy"
}
resource "aws_iam_role_policy_attachment" "eks_container_policy" {
  for_each   = var.node_groups
  role       = aws_iam_role.node_iam_role[each.key].name
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
}
resource "aws_iam_role_policy_attachment" "eks_cni_policy" {
  for_each   = var.node_groups
  role       = aws_iam_role.node_iam_role[each.key].name
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKS_CNI_Policy"
}