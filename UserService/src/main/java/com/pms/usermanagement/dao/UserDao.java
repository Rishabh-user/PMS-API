package com.pms.usermanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pms.usermanagement.model.User;

public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	Optional<User> findByEmail(String email);

	Optional<User> findByPhoneNo(String userName);

	boolean existsByEmail(String email);

	boolean existsByPhoneNo(String phoneNo);




//	Optional<User> findByEmail(String email);
//
//	Optional<User> findByEmailOrUserDetailPhoneNo(String email, String phoneNo);
//
//	Optional<User> findByUserId(Long userId);
//
//	boolean existsByEmail(String email);
//
//	List<User> findUserByRoleRole(RoleStatus role);
//
//	List<User> findUserByUserStatus(UserStatus userStatus);
//
//	List<User> findUserByRoleRoleOrderByUserId(RoleStatus user);
//
//	boolean existsByEmailAndUserStatus(String email, UserStatus active);
//
//	Optional<User> findByEmailAndUserStatus(String email, UserStatus active);
//
//	List<User> findByUserStatusAndRoleRole(UserStatus active, RoleStatus user);
//
////	Optional<User> findByRandomId(String oldRandomId);
//
////	@Query("select t from User t where t.userDetail.phoneNo = ?1 OR t.email = ?1")
////	Optional<User> findByUserDetailPhoneNoOrEmail(String email);
//
//	Optional<User> findByUserDetailPhoneNo(String phoneNo);
//
//	Optional<User> findByUserStatusAndEmail(UserStatus unverified, String email);
//
//	Optional<User> findByUserStatusAndUserId(UserStatus active, Long userId);
//
//	Optional<User> findUserByRoleRoleAndUserStatus(RoleStatus admin, UserStatus active);
//
//	boolean existsByCompanyName(String companyName);
//
//	Optional<User> findByPhoneNo(String userName);



}
