package com.sunrise.sunrisellc.users;

import java.util.List;

public interface UserService {
	
	String addUser(UserDTO userDTO);

	List<UserInfo> getUsers();
}
