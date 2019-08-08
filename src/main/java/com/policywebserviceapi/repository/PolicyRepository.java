package com.policywebserviceapi.repository;

import com.policywebserviceapi.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PolicyRepository extends JpaRepository<Policy, Long>{

}