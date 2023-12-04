resource "aws_s3_bucket" "lambda_code_bucket" {
  bucket = "customer-repo-bucket" # Replace with your bucket name
  acl    = "private"
}

resource "aws_s3_bucket" "target_bucket" {
  bucket = "customer-repo-bucket" # Replace with your bucket name
  acl    = "private"
}
