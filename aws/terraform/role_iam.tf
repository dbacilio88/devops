resource "aws_iam_role" "iam_cluster_bacsystem" {
  name               = "iam_cluster_bacsystem"
  description        = "Allows EKS to manage clusters on your behalf."
  assume_role_policy = data.aws_iam_policy_document.assume_role_eks.json
}

resource "aws_iam_role" "iam_node_group_bacsystem" {
  name               = "iam_node_group_bacsystem"
  description        = "Allows EKS to manage clusters on your behalf."
  assume_role_policy = data.aws_iam_policy_document.assume_role_ec2.json
}

