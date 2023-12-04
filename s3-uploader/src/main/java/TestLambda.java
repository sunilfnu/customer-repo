import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.nio.ByteBuffer;
import java.util.Random;

public class TestLambda {
    public void handlerMethod() {
        S3Client s3 = S3Client.builder()
                .region(Region.US_EAST_1) // Replace with your region
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        String bucketName = "customer-repo-bucket"; // Replace with your bucket name
        String key = "your-file-key"; // Replace with the desired key

        // Example: Uploading a random byte buffer. Replace this with your file's content.
        byte[] content = new byte[1024];
        new Random().nextBytes(content);
        ByteBuffer buffer = ByteBuffer.wrap(content);

        uploadFile(s3, bucketName, key, buffer);
    }

    private void uploadFile(S3Client s3, String bucketName, String key, ByteBuffer buffer) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .build();
        PutObjectResponse response = s3.putObject(putObjectRequest, RequestBody.fromByteBuffer(buffer));

        System.out.println("File uploaded. Response: " + response);
    }

}
