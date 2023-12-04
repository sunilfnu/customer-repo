provider "aws" {
  region = "us-west-1" # Replace with your region
}

resource "aws_iam_role" "lambda_role" {
  name = "lambda_role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Action = "sts:AssumeRole",
        Effect = "Allow",
        Principal = {
          Service = "lambda.amazonaws.com"
        },
      },
    ],
  })
}

resource "aws_iam_role_policy" "lambda_policy" {
  name = "lambda_policy"
  role = aws_iam_role.lambda_role.id

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Action = [
          "s3:PutObject",
          "s3:GetObject"
        ],
        Resource = "arn:aws:s3:::your-bucket-name/*", # Replace with your S3 bucket ARN
        Effect = "Allow"
      },
    ],
  })
}

resource "aws_lambda_function" "s3_uploader" {
  function_name = "S3FileUploader"

  s3_bucket = aws_s3_bucket.lambda_code_bucket # Replace with your deployment bucket name
  s3_key    = "src/main/java/TestLambda.java"   # Replace with your code zip file

  handler = "src/main/java/TestLambda::handlerMethod" # Replace with the handler
  runtime = "java11"

  role = aws_iam_role.lambda_role.arn

  timeout     = 60
  memory_size = 128
}

# Add other necessary resources and configurations here
