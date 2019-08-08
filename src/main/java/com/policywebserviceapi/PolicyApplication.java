package com.policywebserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PolicyApplication {
	public static void main(String[] args) {

		SpringApplication.run(PolicyApplication.class, args);
	}
}
