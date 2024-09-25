package com.pms.usermanagement.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.pms.usermanagement.enums.RoleStatus;
import com.pms.usermanagement.enums.UserStatus;

public class SignupDto {

	private String firstName;

	private String lastName;
	

	@Email
	private String email;

	@Size(min = 8, message = "password should be atleast 8 characters")
	@Size(max = 16, message = "password should be atmost 16 characters")
	private String password;

	private String phoneNo;

	private RoleStatus roleStatus;
	
	private UserStatus userStatus;

	private String country;

	private String city;

	private String state;

	private String companyAddress;

	private String imageUrl;

	private String organisationId;
	
	private String companyName;
	
	private List<String> module;
	
	private String zipCode;
	
	//private List<ModuleSelection> module;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public RoleStatus getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(RoleStatus roleStatus) {
		this.roleStatus = roleStatus;

	}

	private String countryCode;


	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	


	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<String> getModule() {
		return module;
	}

	public void setModule(List<String> module) {
		this.module = module;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	
	

}
