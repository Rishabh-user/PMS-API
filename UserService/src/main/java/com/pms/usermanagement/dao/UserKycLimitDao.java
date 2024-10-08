package com.pms.usermanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.model.UserKycLimit;

public interface UserKycLimitDao extends JpaRepository<UserKycLimit, Long> {

    List<UserKycLimit> findByUserId(Long userId);
    
}