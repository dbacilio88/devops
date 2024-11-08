# modules/ecr/outputs.tf

output "repository_id" {
  description = "The ID of the ECR repository."
  value       = aws_ecr_repository.this.id
}

output "repository_arn" {
  description = "The ARN of the ECR repository."
  value       = aws_ecr_repository.this.arn
}

output "repository_uri" {
  description = "The URI of the ECR repository."
  value       = aws_ecr_repository.this.repository_url
}
