package com.policywebserviceapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policywebserviceapi.model.User;
import com.policywebserviceapi.repository.UserRepository;

@Service
public class UserDAO {

	@Autowired
	UserRepository userRepository;
	
	/* to save an policy */
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	/* search all policy */
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/* get an policy */
	
	public User findOne(Long userID) {
		return userRepository.findOne(userID);
	}
	
	/* delete an policy by id */
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
