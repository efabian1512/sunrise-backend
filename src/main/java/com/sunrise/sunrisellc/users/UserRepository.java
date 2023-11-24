package com.sunrise.sunrisellc.users;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, UUID> {
	
	Optional<UserInfo> findOneByEmailAndPassword(String email, String password);

	Optional<UserInfo> findByEmail(String username);
	
	

	

}
