package com.pms.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long countryId;

	private String countryCode;

	private String countryName;
	
	private String countryPhonecode;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryPhonecode() {
		return countryPhonecode;
	}

	public void setCountryPhonecode(String countryPhonecode) {
		this.countryPhonecode = countryPhonecode;
	}



}
