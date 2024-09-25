package com.pms.usermanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pms.usermanagement.enums.UserStatus;
import com.pms.usermanagement.util.TwoFaType;

@Entity
@Table
@Where(clause = "user_status!='DELETED'")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String email;

	private String password;

	@Column(columnDefinition = "varchar(32) default 'UNVERIFIED'")
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus = UserStatus.UNVERIFIED;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "FK_COMPANY_ID")
//	private Company company;
	
	 @ManyToOne(cascade = CascadeType.ALL) // This line allows cascading
	    @JoinColumn(name = "company_id")
	    private Company company;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_Role")
	private Role role;
	
	private String firstName;
	private String lastName;
	private String phoneNo;
	@Column(columnDefinition = "varchar(32) default 'NONE'")
	@Enumerated(EnumType.STRING)
	private TwoFaType twoFaType = TwoFaType.NONE;
	

	private String imageUrl;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public TwoFaType getTwoFaType() {
		return twoFaType;
	}

	public void setTwoFaType(TwoFaType twoFaType) {
		this.twoFaType = twoFaType;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}