package com.pms.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.model.Company;

public interface CompanyDao extends JpaRepository<Company, Long> {

	boolean existsByCompanyName(String companyName);

}
