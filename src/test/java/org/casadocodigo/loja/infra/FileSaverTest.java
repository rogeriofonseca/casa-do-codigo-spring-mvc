package org.casadocodigo.loja.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;

public class FileSaverTest {

	public static void main(String[] args) throws FileNotFoundException {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY");
        AmazonS3Client newClient = new AmazonS3Client(credentials,
                new ClientConfiguration());
        newClient.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
        newClient.setEndpoint("http://localhost:9444/s3");
        FileInputStream file = new FileInputStream(new File("/Users/alberto/Desktop/s3ninja-sempasta.png"));
        PutObjectResult putObject = newClient.putObject("casadocodigo", "arquivo.java", file, new ObjectMetadata());
		
	}
}