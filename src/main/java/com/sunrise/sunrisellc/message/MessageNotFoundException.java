package com.sunrise.sunrisellc.message;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MessageNotFoundException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(String message) {
		super(message);
	}

}
