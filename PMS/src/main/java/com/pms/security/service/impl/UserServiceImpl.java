/**
 * 
 */
package com.pms.security.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.security.dto.RegisterRequest;
import com.pms.security.entity.Role;
import com.pms.security.entity.User;
import com.pms.security.repository.UserRepository;
import com.pms.security.service.IUserService;

/**
 * 
 */
@Service
public class UserServiceImpl implements IUserService {
	
	  private final UserRepository userRepository ;
	    private final PasswordEncoder passwordEncoder;
	
	 public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

	    public User registerNewUser(RegisterRequest request) {
	        // Check if username already exists
	        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
	            throw new RuntimeException("Username already exists");
	        }

	        // Create new user with encrypted password
	        User user = new User();
	        user.setUsername(request.getUsername());
	        user.setPassword(passwordEncoder.encode(request.getPassword()));
	        Set<Role> setRole= new HashSet<Role>();
	        Role r= new Role();
	        r.setName(request.getRole());
	        setRole.add(r);
	        user.setRoles(setRole);
	        user.setEnabled(true);
	        //user.setRoles(request.getRole() != null ? request.getRole() : "ROLE_USER");

	        return userRepository.save(user);
	    }
}
