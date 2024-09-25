//package com.pms.usermanagement.dao;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.pms.usermanagement.enums.UserStatus;
//import com.pms.usermanagement.model.UserDetail;
//
//public interface UserDetailsDao extends JpaRepository<UserDetail, Long> {
//
//	boolean existsByPhoneNo(String phoneNo);
//
//	
//	boolean existsByPhoneNoAndUserUserStatus(String phoneNo, UserStatus active);
//
//	Optional<UserDetail> findByUserUserId(Long userId);
//
//	
//	
//	
//
//	Optional<UserDetail> findByUserEmail(String email);
//
//
//	List<UserDetail> findByFirstName(String firstName);
//
//	Long countByFirstName(String firstName);
//
//	List<UserDetail> findByFirstNameAndUserUserId(String firstName, Long userId);
//
//
//	List<UserDetail> findByCreateTimeBetween(Date date, Date date2);
//
//	List<UserDetail> findByCreateTimeBetweenAndUserDetailId(Date date, Date date2, Long userId);
//
//
//}
