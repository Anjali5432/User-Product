package com.user.uapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.uapp.exception.ResourceNotFoundException;
import com.user.uapp.model.APIResponse;
import com.user.uapp.model.User;
import com.user.uapp.services.UserService;

@RestController 
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController(UserService userservice) {
		super();
		this.userService = userservice;
	}
	
	//build create user Rest Api
	//http://localhost:8080/api/users
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
		
	}
	
	// build get all users REST API
	//http://localhost:8080/api/users
	@GetMapping()
	public List<User> getAllusers(){
		return userService.getAllUsers();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/users/1
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse> getuserById(@PathVariable("id") long userId){
		APIResponse apiResponse = userService.getUserById(userId);
				return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		
	}
	
	// build update user REST API
	// http://localhost:8080/api/users/1
	@PutMapping("{id}")
	public ResponseEntity<User> updateuser(@PathVariable("id") long id , @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/users/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteuser(@PathVariable("id") long id){
	// delete user from DB
	userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted successfully!.", HttpStatus.OK);
	}	
	
	
	
	
	/*
	@GetMapping("/byProductId")
	public ResponseEntity<List<User>> getUsersByProductId(@RequestParam int pid) {
	    try {
	        List<User> users = userService.getUsersByProductId(pid);
	        if (users.isEmpty()) {
	            // Return a 204 No Content status if no users are found
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(users); // Return 200 OK with the list of users
	    } catch (Exception e) {
	        // Log the exception (you can use a logger here)
	        System.err.println("Error occurred while fetching users by product ID: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Return 500 Internal Server Error
	    }
	}
	*/
	
	 @GetMapping("/product/{pid}")
	    public ResponseEntity<Boolean> isProductInUse(@PathVariable("pid") Long pid) {
	        Boolean isInUse = userService.isProductInUse(pid);
	        return ResponseEntity.ok(isInUse);
	    }
}
