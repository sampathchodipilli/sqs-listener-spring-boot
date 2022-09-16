package com.sqs.sqslistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration(exclude=ContextStackAutoConfiguration.class)
@EnableScheduling
public class SqsListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsListenerApplication.class, args);
	}

}
