//package com.pms.usermanagement.model;
//
//import java.util.Date;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import com.pms.usermanagement.enums.UserStatus;
//import com.pms.usermanagement.util.TwoFaType;
//
//@Entity
//@Table
//public class UserDetail {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long userDetailId;
//	private String firstName;
//	private String lastName;
//	private String phoneNo;
//	@Column(columnDefinition = "varchar(32) default 'NONE'")
//	@Enumerated(EnumType.STRING)
//	private TwoFaType twoFaType = TwoFaType.NONE;
//	private String secretKey;
//	private String country;
//	private String city;
//	private String state;
//	private String countryCode;
//	private String zipCode;
//
//	private String imageUrl;
//
//	@Enumerated(EnumType.STRING)
//	private UserStatus userStatus;
//
////	@OneToOne(cascade = CascadeType.ALL)
////	@JoinColumn(name = "fk_user_detail")
////	private UserDetail userDetail;
//
////	public UserDetail getUserDetail() {
////		return userDetail;
////	}
////
////	public void setUserDetail(UserDetail userDetail) {
////		this.userDetail = userDetail;
////	}
//
//	public UserStatus getUserStatus() {
//		return userStatus;
//	}
//
//	public void setUserStatus(UserStatus userStatus) {
//		this.userStatus = userStatus;
//	}
//
//	public String getZipCode() {
//		return zipCode;
//	}
//
//	public void setZipCode(String zipCode) {
//		this.zipCode = zipCode;
//	}
//
//	public String getCountryCode() {
//		return countryCode;
//	}
//
//	public void setCountryCode(String countryCode) {
//		this.countryCode = countryCode;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
//	private User user;
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	@CreationTimestamp
//	private Date createTime;
//
//	@UpdateTimestamp
//	private Date updateTime;
//
//	public Long getUserDetailId() {
//		return userDetailId;
//	}
//
//	public TwoFaType getTwoFaType() {
//		return twoFaType;
//	}
//
//	public void setTwoFaType(TwoFaType twoFaType) {
//		this.twoFaType = twoFaType;
//	}
//
//	public void setUserDetailId(Long userDetailId) {
//		this.userDetailId = userDetailId;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getPhoneNo() {
//		return phoneNo;
//	}
//
//	public void setPhoneNo(String phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//
//	public String getSecretKey() {
//		return secretKey;
//	}
//
//	public void setSecretKey(String secretKey) {
//		this.secretKey = secretKey;
//	}
//
//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public Date getUpdateTime() {
//		return updateTime;
//	}
//
//	public void setUpdateTime(Date updateTime) {
//		this.updateTime = updateTime;
//	}
//
//}
