package com.pms.usermanagement.model;

import java.util.List;

import com.pms.usermanagement.dto.Country;


public class StateList {
	
	//@JsonProperty("collection")
	private List<Country> countries;

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}


	

	
}
