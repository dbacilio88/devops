data "aws_key_pair" "key" {
  key_name = "instance_aws"
  depends_on = [
    aws_key_pair.kp_bacsystem_key
  ]
}

data "aws_iam_policy_document" "assume_role_eks" {
  statement {
    effect = "Allow"
    principals {
      identifiers = [
        "eks.amazonaws.com"
      ]
      type = "Service"
    }

    actions = [
      "sts:AssumeRole"
    ]
    sid = ""
  }
  version = "2012-10-17"
}

data "aws_iam_policy_document" "assume_role_ec2" {
  statement {
    effect = "Allow"
    principals {
      identifiers = [
        "ec2.amazonaws.com"
      ]
      type = "Service"
    }

    actions = [
      "sts:AssumeRole"
    ]
    sid = ""
  }
  version = "2012-10-17"
}