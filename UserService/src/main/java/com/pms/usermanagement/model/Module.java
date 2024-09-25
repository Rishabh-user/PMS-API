package com.pms.usermanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pms.usermanagement.enums.ModuleStatus;

@Entity
@Table
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ModuleStatus moduleName;

	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "module")
	private List<Company> company;



	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public ModuleStatus getModuleName() {
		return moduleName;
	}

	public void setModuleName(ModuleStatus moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	
}
