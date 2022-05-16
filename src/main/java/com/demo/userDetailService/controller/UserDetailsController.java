package com.demo.userDetailService.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.userDetailService.models.Ratting;
import com.demo.userDetailService.models.User;
import com.demo.userDetailService.models.UserDetails;
import com.demo.userDetailService.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/userDetailService")
@CrossOrigin
@Api(value = "UserDetailsController")
public class UserDetailsController {
	
	@Autowired
	RestTemplate restTemplate ;
	
	
	@Autowired
	UserService userService;
	
	
//	http://localhost:8080/serviceA/getUserDetails
	
	// calling other service
		
	@GetMapping("/getUserDetails")
	public List<UserDetails> getUserDetails(){
		
		 return userService.getAllUser().stream()
		 .map(i ->{
			 Ratting ratting =  restTemplate.getForObject("http://USER-RATTING-SERVICE/serviceB/getAllUserRatting/"+i.getId(), Ratting.class);
		 
		 return  new UserDetails(i.getId(),i.getFirstName(),i.getLastName(),i.getMobileNumber(),i.getPlace(),ratting.getRatting(),ratting.getComment());
				 }).collect(Collectors.toList());
	}
	

//	http://localhost:8080/userDetailService/getAllUser
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		
		 return userService.getAllUser();
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody  User user ) {
		 return userService.addUser(user);
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable("id") int id,@RequestBody  User user) {
		 return userService.updateUser(id,user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		 return userService.deleteUser(id);
	}
	//testing

}
