package com.pms.usermanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.auth0.jwt.internal.com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String organisationId;
    private String companyName;
    private String companyAddres;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    // This should be a ManyToOne relationship, not a String
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<User> user;

    private String country;
    private String city;
    private String state;
    private String countryCode;
    private String zipCode;

    
	@JsonIgnore
	@OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
	private List<Company> company;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public String getCompanyAddres() {
		return companyAddres;
	}

	public void setCompanyAddres(String companyAddres) {
		this.companyAddres = companyAddres;
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
//
//	public Module getModule() {
//		return module;
//	}
//
//	public void setModule(Module module) {
//		this.module = module;
//	}

	


	public List<User> getUser() {
		return user;
	}



	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

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

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public void setUser(User user2) {
		// TODO Auto-generated method stub
		
	}

	public void setModules(List<Module> modules) {
		// TODO Auto-generated method stub
		
	}
    
    
    
	

}
