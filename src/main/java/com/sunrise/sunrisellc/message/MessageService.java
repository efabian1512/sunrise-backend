package com.sunrise.sunrisellc.message;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
	
private MessageRepository messageRepository;

	MessageService(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}
	
	public List<Message> getMessges() {
		return messageRepository.findAll();
	}
	
	public Message saveMessage(Message message) {
		
		return messageRepository.save(message);
	}
}
