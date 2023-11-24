package com.sunrise.sunrisellc.users.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sunrise.sunrisellc.users.UserInfo;
import com.sunrise.sunrisellc.users.UserDTO;
import com.sunrise.sunrisellc.users.UserRepository;
import com.sunrise.sunrisellc.users.UserService;

@Component
public class UserIMPL implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public String addUser(UserDTO userDTO) {
		
		UserInfo userInfo = new UserInfo(
				
			userDTO.getId(),
			userDTO.getName(),
			userDTO.getEmail(),
			this.passwordEncoder.encode(userDTO.getPassword()),
			userDTO.getRoles()
		);
		
		userRepository.save(userInfo);
				
		return userInfo.getName();
	}


	@Override
	public List<UserInfo> getUsers() {
		List<UserInfo> users = userRepository.findAll();
		
		if(users.isEmpty())
			return List.of();
		
		
		return users;
	}

}
