package com.hcl.cs.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hcl.cs.model.Role;
import com.hcl.cs.model.User;
import com.hcl.cs.model.UserRole;
import com.hcl.cs.repository.UserRepository;
import com.hcl.cs.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		User saveduser = userRepository.save(user);
		for(Role role: user.getRoles()) {
		UserRole ur = new UserRole();
		ur.setUser(saveduser);
		ur.setRole(role);
		userRoleRepository.save(ur);
		}
		
		
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User findByUsernameAndPassword(String userName, String userPassword) throws Exception {
		System.out.println(userName + "-" + userPassword);
		User user = userRepository.findByUserName(userName);
		System.out.println(user);
		if (user == null) {
			throw new Exception("Invalid Login Credential");
		}else {
			String encryptedPassword = user.getUserPassword();
			
		}
		if (passwordEncoder.matches(userPassword, user.getUserPassword())) {
			
		}else {
			throw new Exception("Invalid Password Credential");
		}
		
		return user;
	}

	@Override
	public User findByUserId(Long userId) {
		User user = userRepository.findByUserId(userId).orElse(null);
		if (user == null) {
			throw new RuntimeException("Invalid User ID");
		}
		return user;
	}

}
