package com.user.uapp.services;

import java.util.List;

import com.user.uapp.model.APIResponse;
import com.user.uapp.model.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	APIResponse getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
	//List<User> getUsersByProductId(int pid);
	Boolean isProductInUse(Long pid);

}
