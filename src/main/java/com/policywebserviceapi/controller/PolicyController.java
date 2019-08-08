package com.policywebserviceapi.controller;

import java.util.List;

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

import com.policywebserviceapi.dao.PolicyDAO;
import com.policywebserviceapi.model.Policy;

@RestController
@RequestMapping("/softtech")
public class PolicyController {
	
	@Autowired
	PolicyDAO policyDAO;
	
	/* to save an policy */
	@PostMapping("/policy")
	public Policy createPolicy(@Valid @RequestBody Policy pol) {
		return policyDAO.save(pol);
	}
	
	/* get all policy */
	@GetMapping("/policy")
	public List<Policy> getAllPolicy(){
		return policyDAO.findAll();
	}
	
	/* get policy by polID */
	@GetMapping("/policy/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable (value="id") Integer polID){
		Policy pol = policyDAO.findOne(polID);
		if(pol == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pol);
	}
	
	/* update an policy by polID */
	@PutMapping("/policy/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable (value="id") Integer polID,@Valid @RequestBody Policy polDetails){
		Policy pol = policyDAO.findOne(polID);
		if(pol == null) {
			return ResponseEntity.notFound().build();
		}
		
		pol.setPolicyNo(polDetails.getPolicyNo());
		pol.setPolicyStartDate(polDetails.getPolicyStartDate());
		pol.setPolicyEndDate(polDetails.getPolicyEndDate());
		pol.setPolicyIssueDate(polDetails.getPolicyIssueDate());
		pol.setPolicyLastUpdateDate(polDetails.getPolicyLastUpdateDate());
		pol.setPolicyStatus(polDetails.getPolicyStatus());
		pol.setPolicyPremium(polDetails.getPolicyPremium());
		pol.setPolicyType(polDetails.getPolicyType());
		
		Policy updatePolicy = policyDAO.save(pol);
		return ResponseEntity.ok().body(updatePolicy);
		
	}
	
	
	/* delete an policy */
	@DeleteMapping("/policy/{id}")
	public ResponseEntity<Policy> deletePolicy(@PathVariable (value="id") Integer polID){
		
		Policy pol = policyDAO.findOne(polID);
		if(pol == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
		
	}
	
	

}
