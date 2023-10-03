package com.sam.kafkaspringboot.restcontrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sam.kafkaspringboot.messagerepo.MessageRepository;
import com.sam.kafkaspringboot.producers.MessageProducer;

@RestController
@RequestMapping("/messageControllers")
public class MessageControllers {
	
	Logger log = LoggerFactory.getLogger(MessageControllers.class);
	
	@Autowired
	private MessageProducer messageProducer;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/sendMessages")
	public void sendMessages(@RequestParam("message") String message) {
		log.info("Sending Message from Controllers", message);
		messageProducer.sendMessage(message);
		
	}
	
	@GetMapping("/getMessages")
	public String getMassages(){
		
		return messageRepository.getMessages();
	}

}
