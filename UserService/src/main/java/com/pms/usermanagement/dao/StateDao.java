package com.pms.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.model.States;

public interface StateDao extends JpaRepository<States, Long> {

//	List<States> findByCountriesCountriesId(Long countryId);
//
//	List<States> findByCountriesCountriesIdAndStatusTrue(Long castCountryId);
//
//	List<States> findByCountriesCountryCode(String countryCode);

}
