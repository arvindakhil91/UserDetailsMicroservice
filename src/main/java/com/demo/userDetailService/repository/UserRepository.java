package com.demo.userDetailService.repository;
import org.springframework.data.repository.CrudRepository;

import com.demo.userDetailService.models.User;  

public interface UserRepository extends CrudRepository<User, Integer>  
{  
	
}  
