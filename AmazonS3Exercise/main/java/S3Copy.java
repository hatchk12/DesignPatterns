import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


public class S3Copy {

    public void upload(String fileName,byte[] buffer) throws IOException {
        //usage <bucketName> <fileName>

        // Create AmazonS3 object for doing S3 operations
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withRegion("us-east-2")
                .build();
        String bucketName = "hatchk12-tweeterimages";
        //            String fileName = "imageTest3.png";
//        if(args.length == 2) {
//            bucketName = args[0];
//            fileName = args[1];
//
//        }
//        else{
//            Scanner in = new Scanner(System.in);  // Create a Scanner object
//            System.out.println("Enter s3 bucket name");
//            bucketName = in.nextLine();
//            System.out.println("Enter file name to copy");
//            fileName = in.nextLine();
//        }

//        BufferedImage bImage = ImageIO.read(new File("BYU-idependent-study-logo.png"));
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ImageIO.write(bImage, "jpg", bos );
//        byte [] buffer = bos.toByteArray();
        InputStream is = new ByteArrayInputStream(buffer);
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(buffer.length);
        meta.setContentType("image/png");
        s3.putObject(new PutObjectRequest(bucketName, fileName, is, meta));
//        File file = new File("BYU-idependent-study-logo.png");
//        s3.putObject(bucketName,fileName,file);

        // Write code to do the following:
        // 1. get name of file to be copied from the command line
        // 2. get name of S3 bucket from the command line
        // 3. upload file to the specified S3 bucket using the file name as the S3 key
    }
}