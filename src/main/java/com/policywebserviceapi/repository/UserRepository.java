package com.policywebserviceapi.repository;

import com.policywebserviceapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByuserTCKN(Long userTCKN);
	
}