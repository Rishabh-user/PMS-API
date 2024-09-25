package com.pms.usermanagement.dto;

import com.pms.usermanagement.enums.UserStatus;
import com.pms.usermanagement.model.Role;

public class UserResponseDto {
    private Long id;
    private String phoneNo;
    private String email;
    private String companyName;
    private String companyAddress;
    private Role role;
    private String organisationId;
    private UserStatus userStatus;
    private String token;
    private String module;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getOrganisationId() {
		return organisationId;
	}
	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}
	public UserStatus getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}


}

