package com.sam.kafkaspringboot.messagerepo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {
	
	private List<String> messageList = new ArrayList<>();
	
	public void addMessages(String message){
		messageList.add(message);
	}

	public String getMessages() {
		return messageList.toString();
	}
}
