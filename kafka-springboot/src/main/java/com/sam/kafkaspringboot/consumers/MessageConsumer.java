package com.sam.kafkaspringboot.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.sam.kafkaspringboot.messagerepo.MessageRepository;
import com.sam.kafkaspringboot.restcontrollers.MessageControllers;

@Component
public class MessageConsumer {
	
	Logger log = LoggerFactory.getLogger(MessageControllers.class);
	
	@Autowired
	private MessageRepository messageRepository;
	
	@KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
	public void consumeMessage(String message){
		log.info("Message received in MessageConsumer" + message);
		messageRepository.addMessages(message);
		
	}
}
