package com.sqs.sqslistener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

@Configuration
public class AwsConfiguration {
	
	@Bean
	public AmazonS3 amazonS3() {
		AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
				.withRegion("ap-south-1")
				.build();
		return amazonS3;
	}
	
	@Bean
	@Primary
	public AmazonSQS amazonSQS() {
		return AmazonSQSClientBuilder.standard()
				.withRegion("ap-south-1")
				.build();
	}
	
	@Bean
    public AmazonSQSAsync amazonSQSAsync() {
        AmazonSQSAsync amazonSQS = AmazonSQSAsyncClientBuilder.standard()
        .withRegion("ap-south-1").build();
		return amazonSQS;
	}
}
