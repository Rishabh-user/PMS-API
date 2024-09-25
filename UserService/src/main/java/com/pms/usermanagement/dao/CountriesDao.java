package com.pms.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.model.Country;

public interface CountriesDao extends JpaRepository<Country, Long> {

	//List<Countries> findAllOrderByCounrtyASC();

	//List<Country> findAllByOrderByCountryAsc();

}