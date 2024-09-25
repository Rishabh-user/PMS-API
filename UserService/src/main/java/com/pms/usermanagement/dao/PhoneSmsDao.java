package com.pms.usermanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.model.PhoneSms;

public interface PhoneSmsDao extends JpaRepository<PhoneSms, Long>{

	Optional<PhoneSms> findByPhoneNo(String mobileNo);

	Optional<PhoneSms> findByOtp(Integer otp);

	Optional<PhoneSms> findByUserId(Long userDetailId);

	
	

}
