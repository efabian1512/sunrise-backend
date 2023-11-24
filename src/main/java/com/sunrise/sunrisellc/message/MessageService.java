package com.sunrise.sunrisellc.message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
	
private MessageRepository messageRepository;

	MessageService(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}
	
	public List<Message> getMessages() {
		return messageRepository.findAll();
	}
	
	public Message saveMessage(Message message) {
		
		return messageRepository.save(message);
	}

	public Optional<Message> getMessageById(UUID id) {
		
		return messageRepository.findById(id);
	}
}
