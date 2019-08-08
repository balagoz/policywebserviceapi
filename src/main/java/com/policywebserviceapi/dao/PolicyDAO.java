package com.policywebserviceapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policywebserviceapi.model.Policy;
import com.policywebserviceapi.repository.PolicyRepository;

@Service
public class PolicyDAO {

	@Autowired
	PolicyRepository policyRepository;
	
	/* to save an policy */
	
	public Policy save(Policy pol) {
		return policyRepository.save(pol);
	}
	
	/* search all policy */
	
	public List<Policy> findAll(){
		return policyRepository.findAll();
	}
	
	/* get an policy */
	
	public Policy findOne(Long polID) {
		return policyRepository.findOne(polID);
	}
	
	/* delete an policy by id */
	
	public void delete(Policy pol) {
		policyRepository.delete(pol);
	}
	
}
