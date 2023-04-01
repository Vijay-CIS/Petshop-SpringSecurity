package com.hcl.cs.service;


import com.hcl.cs.model.User;

public interface UserService {
		 void save(User user);
		 User findByUserName(String userName);
   		 User findByUsernameAndPassword(String userName, String userPassword) throws Exception;
		 User findByUserId(Long userId);
	     
		
	
		

}
