package com.user.uapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.uapp.exception.ResourceNotFoundException;
import com.user.uapp.model.APIResponse;
import com.user.uapp.model.Product;
import com.user.uapp.model.User;
import com.user.uapp.repository.UserRepository;
import com.user.uapp.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public APIResponse getUserById(long id) {
		 User user = userRepository.findById(id).orElseThrow(() -> 
		              new ResourceNotFoundException("User not found with id :" + id));
		 
		 ResponseEntity<Product> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/products/" + user.getPid(), Product.class);
		 Product product = responseEntity.getBody();
		 //now we have user and product to send as a response, so we will create user and product as a variable in APIResponse class to return
		 APIResponse apiResponse = new APIResponse();
		 apiResponse.setUser(user);
		 apiResponse.setProduct(product);
		 
		 
		 
		 return apiResponse;
	}


	@Override
	public User updateUser(User user, long id) {
		//we need to check whether user with given id is present in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("User not found with id :" + id)); 
				
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAge(user.getAge());
		existingUser.setPid(user.getPid());
		//save existing user to DB
		userRepository.save(existingUser);
			return existingUser;
	}
	
	@Override
	public void deleteUser(long id) {
	//check whether a user exist in a DB or not
	userRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("User not found with id :" + id));
	userRepository.deleteById(id);
	}
	/*
	@Override
	public List<User> getUsersByProductId(int pid) {
	    List<User> users = userRepository.findByPid(pid);
	    if (users.isEmpty()) {
	        // Instead of throwing an exception, you can return an empty list
	        return users; // Return an empty list if no users are found
	    }
	    return users;
	}
	*/
	
	 public Boolean isProductInUse(Long pid) {
	        // Check if any user is associated with the given product ID
	        return userRepository.existsByPid(pid);
	    }
}
