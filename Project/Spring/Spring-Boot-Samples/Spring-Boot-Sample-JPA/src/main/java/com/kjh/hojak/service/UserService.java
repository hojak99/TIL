package com.kjh.hojak.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.hojak.domain.User;
import com.kjh.hojak.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void create(User user) throws Exception {
		Optional.ofNullable(user)
			.filter(temp -> temp.getId() != null)
			.filter(temp -> temp.getEmail() != null)
			.filter(temp -> temp.getName() != null)
			.orElseThrow(() -> new Exception("Create User Exception"));
		
		userRepository.save(user);
	}
}
