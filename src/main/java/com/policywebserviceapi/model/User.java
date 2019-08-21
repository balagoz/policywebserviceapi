package com.policywebserviceapi.model;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.policywebserviceapi.service.ServiceUtil; 

@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User implements java.io.Serializable {

	@Id@GeneratedValue(strategy=IDENTITY)
	private Long userid;
	
	private String userKey;
	
	private Long userTCKN;
	
	private String userSurname;
	private String userName;
	private String userEmail;
	private String userPhone;
	
	public User() {
		
	   }
	
	   public User(String userKey, Long userTCKN, String userSurname, String userName,String userEmail, String userPhone) {
	      this.userKey = userKey;
	      this.userTCKN = userTCKN;
	      this.userSurname = userSurname;
	      this.userName = userName;
	      this.userEmail = userEmail;
	      this.userPhone = userPhone;
	   }
	
	   @Id@GeneratedValue(strategy=IDENTITY)
	   @Column(name="id", unique=true, nullable=true)
	   public Long getUserid() {
	       return this.userid;
	   }
	   
	   public void setUserid(Long userid) {
	       this.userid = userid;
	   }

	   @Column(name="user_key", unique=true, nullable=true)
	   public String getUserKey() {
		   return this.userKey;
		}
		
		public void setUserKey(String userKey) {
			this.userKey = userKey;
		}
		
	   @Column(name="user_tckn", nullable=true, length=10)
	   public Long getUserTCKN() {
	       return this.userTCKN;
	   }
	   
	   public void setUserTCKN(Long userTCKN) {
	       this.userTCKN = userTCKN;
	   }

	   
	   @Column(name="user_surname", unique=true, nullable=true)
	   public String getUserSurname() {
		   return this.userSurname;
		}
		
		public void setUserSurname(String userSurname) {
			this.userSurname = userSurname;
		}
	   
		@Column(name="user_name", unique=true, nullable=true)
	    public String getUserName() {
		   return this.userName;
		}
		
		public void setUserName(String userName) {
			this.userName = userName;
		}


		@Column(name="user_email", unique=true, nullable=true)
		public String getUserEmail() {
		   return this.userEmail;
		}
		
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		
		@Column(name="user_phone_number", unique=true, nullable=true)
	    public String getUserPhone() {
		   return this.userPhone;
		}
		
		public void setUserPhone(String userPhone) {
			this.userPhone = userPhone;
		}
   

	
	
}
