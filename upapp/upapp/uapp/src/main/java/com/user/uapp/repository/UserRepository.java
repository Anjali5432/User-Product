package com.user.uapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.uapp.model.User;


public interface UserRepository extends JpaRepository<User,Long>{
	
	//List<User> findByPid(int pid); // Custom query to find users by product ID
	
	// Custom method to check if any user has the given pid
    boolean existsByPid(Long pid);

}
