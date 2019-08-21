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
	
	/* to save an user */
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	/* search all user */
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/* get an user */
	
	public User findOne(Long userID) {
		return userRepository.findOne(userID);
	}
	
	public User findOneTckn(Long userTCKN) {
		return userRepository.findByuserTCKN(userTCKN);
	}
	 
	
	/* delete an user by id */
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
