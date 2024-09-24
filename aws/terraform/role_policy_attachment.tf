#=============================
### POLICY_ATTACHMENT CLUSTER ###
#=============================
resource "aws_iam_role_policy_attachment" "policy_bacsystem_cluster" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy"
  role       = aws_iam_role.iam_cluster_bacsystem.name
}

resource "aws_iam_role_policy_attachment" "policy_bacsystem_vpc_controller" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSVPCResourceController"
  role       = aws_iam_role.iam_cluster_bacsystem.name
}

#=============================
### POLICY_ATTACHMENT NODE ###
#=============================

resource "aws_iam_role_policy_attachment" "policy_bacsystem_worker_node" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSWorkerNodePolicy"
  role       = aws_iam_role.iam_node_group_bacsystem.name
}
resource "aws_iam_role_policy_attachment" "policy_bacsystem_eks_cni" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKS_CNI_Policy"
  role       = aws_iam_role.iam_node_group_bacsystem.name
}
resource "aws_iam_role_policy_attachment" "policy_bacsystem_container_registry" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
  role       = aws_iam_role.iam_node_group_bacsystem.name
}