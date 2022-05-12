package com.demo.userDetailService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.userDetailService.models.User;
import com.demo.userDetailService.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired  
	UserRepository userRepository; 
	
	public List<User> getAllUser()   
	{  
	List<User> users = new ArrayList<User>();  
	userRepository.findAll().forEach(user -> users.add(user));  
	return users;  
	} 
	
	
	public String addUser(User user) {
		userRepository.save(user);
		return "Success";
	}
	
	public User updateUser(int id,User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	public String deleteUser(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			userRepository.delete(user.get());
			return "Deleted";
		}
		return "Delete Failed";
	}

}
