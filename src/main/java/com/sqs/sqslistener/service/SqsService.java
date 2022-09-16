package com.sqs.sqslistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

@Service
public class SqsService {

	@Autowired
	private AmazonSQS amazonSqs;
	
	private Integer count = 0;

	@SqsListener("test-queue")
	public void sqsApp(String message) {
		
		if(message.equalsIgnoreCase("startcoding")) {
			System.out.println();
			count++;
			System.out.println(count+". Message (receiver) : " + message);
		}
		
	}

	@Scheduled(fixedDelay = 3600000)
	public void publishSqs() {
		System.out.println("Start");
		String queueUrl = amazonSqs.getQueueUrl("test-queue").getQueueUrl();
		SendMessageRequest request = new SendMessageRequest()
				.withQueueUrl(queueUrl)
				.withMessageBody("Hellloooo")
				.withDelaySeconds(0);
		for(int i=0;i<1000;i++) {
			SendMessageResult result = amazonSqs.sendMessage(request);
			System.out.println("result = " + result);
			if(i==999) {
				amazonSqs.sendMessage(queueUrl, "startcoding");
			}
		}
		System.out.println("End");
	}
}
