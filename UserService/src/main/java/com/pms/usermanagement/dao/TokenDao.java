package com.pms.usermanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.usermanagement.model.TokenDetails;

public interface TokenDao extends JpaRepository<TokenDetails, Long> {

	Optional<TokenDetails> findByUserId(Long userId);

	Optional<TokenDetails> findByToken(String token);

	Optional<TokenDetails> findByEmail(String email);

}