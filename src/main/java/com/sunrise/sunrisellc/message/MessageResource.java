package com.sunrise.sunrisellc.message;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Message> getMessages(){
		return messageService.getMessages();
	}
	
	@GetMapping("sunrise/messages/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Message> getMessageById(@PathVariable UUID id){
		Optional<Message> retievedMessage = messageService.getMessageById(id);
		
		if(retievedMessage.isEmpty())
			throw new MessageNotFoundException("The message with id: "+id.toString()+ "was not found.");
		
		return ResponseEntity.status(HttpStatus.OK).body(retievedMessage.get());
	}
	
	@PostMapping("sunrise/messages")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Message> saveMessage(@Valid @RequestBody Message message) {
		
		Message saveMessage = messageService.saveMessage(message);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveMessage.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
