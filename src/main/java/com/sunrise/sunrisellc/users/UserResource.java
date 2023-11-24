package com.sunrise.sunrisellc.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserResource {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("sunrise/users")
	public List<UserInfo>getUsers() {
		
		return userService.getUsers();
	}

	@PostMapping("sunrise/users/new")
	public String saveUser(@RequestBody UserDTO userDto) {
		
		String id = userService.addUser(userDto);
		return id;
	}

}
