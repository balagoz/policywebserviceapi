package com.policywebserviceapi.controller;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policywebserviceapi.dao.UserDAO;
import com.policywebserviceapi.model.Policy;
import com.policywebserviceapi.model.User;
import com.policywebserviceapi.service.ServiceUtil;

@RestController
@RequestMapping("/softtech")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	/* to save an policy */
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		/*pol.setPolicyKey(ServiceUtil.generateKey());
		pol.setPolicyEndDate(ServiceUtil.getNextYearToday());
		pol.setPolicyIssueDate(ServiceUtil.getToday());
		return policyDAO.save(pol);*/
		user.setUserKey(ServiceUtil.generateKey());
		return userDAO.save(user);
	}
	
	/* get all policy */
	@GetMapping("/user")
	public List<User> getUser(){
		return userDAO.findAll();
	}
	
	/* get policy by polID */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable (value="id") Long userID){
		User us = userDAO.findOne(userID);
		if(us == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(us);
	}
	
	/* get policy by userTC */
	@GetMapping("/user/tckn/{tc}")
	public ResponseEntity<User> getUserByTc(@PathVariable (value="tc") Long userTCKN){
		User us = userDAO.findOneTckn(userTCKN);
		if(us == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(us);
	}
	
	/* update an policy by polID */
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable (value="id") Long userID,@Valid @RequestBody User userDetails){
		/*Policy pol = policyDAO.findOne(polID);
		if(pol == null) {
			return ResponseEntity.notFound().build();
		}
		
		if(polDetails.getPolicyStartDate() != null) {
			pol.setPolicyStartDate(polDetails.getPolicyStartDate());
		}
		if(polDetails.getPolicyEndDate() != null) {
			pol.setPolicyEndDate(polDetails.getPolicyEndDate());
		}
		
		
		pol.setPolicyLastUpdateDate(polDetails.getPolicyLastUpdateDate());
		pol.setPolicyStatus(polDetails.getPolicyStatus());
		pol.setPolicyPremium(polDetails.getPolicyPremium());
		pol.setPolicyType(polDetails.getPolicyType());
		
		Policy updatePolicy = policyDAO.save(pol);
		return ResponseEntity.ok().body(updatePolicy);*/
		return null;
	}
	
	
	/* delete an policy */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> delete(@PathVariable (value="id") Long userID){
		
		User us = userDAO.findOne(userID);
		if(us == null) {
			return ResponseEntity.notFound().build();
		}
		userDAO.delete(us);
		return ResponseEntity.ok().build();
	
	}
	
	/* delete an policy */
	@DeleteMapping("/user/tckn/{tc}")
	public ResponseEntity<User> deleteByTckn(@PathVariable (value="tc") Long userTCKN){
		
		User us = userDAO.findOneTckn(userTCKN);
		if(us == null) {
			return ResponseEntity.notFound().build();
		}
		userDAO.delete(us);
		return ResponseEntity.ok().build();
	
	}
	

}