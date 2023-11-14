package com.sunrise.sunrisellc.contact;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
@RestController
public class MessageResource {

	private MessageService messageService;
	
	MessageResource(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@GetMapping("sunrise/messages")
	public List<Message> getMessges(){
		return messageService.getMessges();
	}
	
	@PostMapping("sunrise/messages")
	public ResponseEntity<Message> saveMessage(@Valid @RequestBody Message message) {
		
		Message saveMessage = messageService.saveMessage(message);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveMessage.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
