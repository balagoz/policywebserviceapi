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
@Table(name="policy")
@EntityListeners(AuditingEntityListener.class)

public class Policy  implements java.io.Serializable {
    
	@Id@GeneratedValue(strategy=IDENTITY)
	private Long policyNo;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date policyStartDate;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date policyEndDate;
	
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(timezone="Europe/Istanbul" , pattern="yyyy-MM-dd HH:mm:ss z")
    private Date policyIssueDate;
	
    private Date policyLastUpdateDate;
    private String policyStatus;
    private Double policyPremium;
    private String policyType;

   public Policy() {
   }

   public Policy(Date policyStartDate, Date policyEndDate, Date policyIssueDate,Date policyLastUpdateDate, String policyStatus, Double policyPremium, String policyType) {
      this.policyStartDate = policyStartDate;
      this.policyEndDate = policyEndDate;
      this.policyIssueDate = policyIssueDate;
      this.policyLastUpdateDate = policyLastUpdateDate;
      this.policyStatus = policyStatus;
      this.policyPremium = policyPremium;
      this.policyType = policyType;
   }
  
   @Id@GeneratedValue(strategy=IDENTITY)
   @Column(name="policy_no", unique=true, nullable=true)
   public Long getPolicyNo() {
       return this.policyNo;
   }
   
   public void setPolicyNo(Long policyNo) {
       this.policyNo = policyNo;
   }

   
   @Temporal(TemporalType.DATE)
   @Column(name="policy_start_date", nullable=true, length=10)
   public Date getPolicyStartDate() {
       return this.policyStartDate;
   }
   
   public void setPolicyStartDate(Date policyStartDate) {
       this.policyStartDate = policyStartDate;
   }

   @Temporal(TemporalType.DATE)
   @Column(name="policy_end_date", nullable=true, length=10)
   public Date getPolicyEndDate() {
       return this.policyEndDate;
   }
   
   public void setPolicyEndDate(Date policyEndDate) {
       this.policyEndDate = policyEndDate;
   }
   
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="policy_issue_date", nullable=true, length=19)
   public Date getPolicyIssueDate() {
	   //Date today = ServiceUtil.getToday();
       return this.policyIssueDate;
   }
   
   public void setPolicyIssueDate(Date policyIssueDate) {
       this.policyIssueDate = policyIssueDate;
   }
   
   
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name="policy_last_update_date", nullable=true, length=19)
   @LastModifiedDate
   public Date getPolicyLastUpdateDate() {
       return this.policyLastUpdateDate;
   }
   
   public void setPolicyLastUpdateDate(Date policyLastUpdateDate) {
       this.policyLastUpdateDate = policyLastUpdateDate;
   }
   
   @Column(name="policy_status", nullable=true, length=20)
   public String getPolicyStatus() {
       return this.policyStatus;
   }
   
   public void setPolicyStatus(String policyStatus) {
       this.policyStatus = policyStatus;
   }

   
   @Column(name="policy_premium", nullable=true, precision=22, scale=0)
   public Double getPolicyPremium() {
       return this.policyPremium;
   }
   
   public void setPolicyPremium(Double policyPremium) {
       this.policyPremium = policyPremium;
   }

   
   @Column(name="policy_type", nullable=true, length=20)
   public String getPolicyType() {
       return this.policyType;
   }
   
   public void setPolicyType(String policyType) {
       this.policyType = policyType;
   }


}

