package com.pms.usermanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pms.usermanagement.enums.UserStatus;

@Entity
@Table
public class PhoneSms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long otpId;
	
	private Long userId;

	private Integer otp;

	private String phoneNo;
	
	
	@CreationTimestamp
	private Date createTime;

	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	

	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getOtpId() {
		return otpId;
	}

	public void setOtpId(Long otpId) {
		this.otpId = otpId;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	
	
	

}
