package com.sunrise.sunrisellc.contact;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, UUID> {

}
