package com.demo.userDetailsServiceTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.userDetailService.UserDetailsServiceApplication;
import com.demo.userDetailService.models.User;
import com.demo.userDetailService.repository.UserRepository;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserDetailsServiceApplication.class)
public class UserDetailsServiceApplicationTest {
	
	@Autowired  
	UserRepository userRepository; 
	
	@Test
	public void addUserTest() {
		User user = new User();
		user.setId(10);
		user.setFirstName("TestUser");
		user.setLastName("Testing");
		user.setMobileNumber(9878786775L);
		user.setPlace("Kerala");
		userRepository.save(user);
		assertNotNull(userRepository.findById(10).get());
	}
	
	@Test
	public void getAllUserTest() {
		List<User> user  = (List<User>) userRepository.findAll();
		assertNotNull(user);
	}

}
