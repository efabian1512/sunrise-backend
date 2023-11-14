package com.sunrise.sunrisellc.message;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private UUID id;
	@Column(name="sender_name")
	private String senderName;
	@Column(name="sender_email")
	private String senderEmail;
	private String message;
	private Boolean isRead;
	
	
	
	public Message() {
		super();
	}

	public Message(UUID id, String senderName, String senderEmail, String message, Boolean isRead) {
		super();
		this.id = id;
		this.senderName = senderName;
		this.senderEmail = senderEmail;
		this.message = message;
		this.isRead = isRead;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", senderName=" + senderName + ", senderEmail=" + senderEmail + ", message="
				+ message + ", isRead=" + isRead + "]";
	}
	

}
