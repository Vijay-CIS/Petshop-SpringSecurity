package com.hcl.cs.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.hcl.cs.model.Role;
import com.hcl.cs.model.User;
import com.hcl.cs.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
    
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		  User user = userRepository.findByUserName(userName);
		  
		  Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
		  
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), grantedAuthorities);
	}

}
