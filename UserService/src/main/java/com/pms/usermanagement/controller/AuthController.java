package com.pms.usermanagement.controller;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.usermanagement.dao.CompanyDao;
import com.pms.usermanagement.dao.UserDao;
import com.pms.usermanagement.dto.LoginDtos;
import com.pms.usermanagement.dto.UserResponseDto;
import com.pms.usermanagement.model.Company;
import com.pms.usermanagement.model.Response;
import com.pms.usermanagement.model.Responses;
import com.pms.usermanagement.model.User;
import com.pms.usermanagement.util.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private MessageSource messageSource;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDtos loginDto, Locale locale) {
	    Optional<User> userOptional;
	    
	    // Find user by email or phone number
	    if (loginDto.getEmail() != null && !loginDto.getEmail().isEmpty()) {
	        userOptional = userDao.findByEmail(loginDto.getEmail());
	    } else if (loginDto.getPhoneNo() != null && !loginDto.getPhoneNo().isEmpty()) {
	        userOptional = userDao.findByPhoneNo(loginDto.getPhoneNo());
	    } else {
	        return new ResponseEntity<>(new Response<String>(400,
	                null,
	                messageSource.getMessage("usermanagement.login.invalid.credentials", new Object[0], locale)),
	                HttpStatus.BAD_REQUEST);
	    }

	    // Check if user exists
	    if (!userOptional.isPresent()) {
	        return new ResponseEntity<>(new Response<String>(404,
	                null,
	                messageSource.getMessage("usermanagement.login.user.notfound", new Object[0], locale)),
	                HttpStatus.NOT_FOUND);
	    }

	    User user = userOptional.get();
	    
	    // Verify password
	    if (!bCryptPasswordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
	        return new ResponseEntity<>(new Response<String>(401,
	                null,
	                messageSource.getMessage("usermanagement.login.invalid.password", new Object[0], locale)),
	                HttpStatus.UNAUTHORIZED);
	    }

	    // Fetch associated company
	    Optional<Company> companyOptional = companyDao.findById(user.getCompany().getCompanyId());
	    if (!companyOptional.isPresent()) {
	        return new ResponseEntity<>(new Response<String>(404,
	                null,
	                messageSource.getMessage("usermanagement.login.company.notfound", new Object[0], locale)),
	                HttpStatus.NOT_FOUND);
	    }
	    Company company = companyOptional.get();

	    // Generate token
	    String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole().getRole());

	    // Prepare user details in response
	    UserResponseDto userResponse = new UserResponseDto();
	    userResponse.setId(user.getUserId());
	    userResponse.setPhoneNo(user.getPhoneNo());
	    userResponse.setEmail(user.getEmail());
	    userResponse.setRole(user.getRole());
	    userResponse.setUserStatus(user.getUserStatus());
	    userResponse.setCompanyName(company.getCompanyName());
	    userResponse.setCompanyAddress(company.getCompanyAddres());
	    userResponse.setOrganisationId(company.getOrganisationId());
	    userResponse.setToken(token);

	    // Return full response with 200 status, explicitly specify Response<UserResponseDto>
	    return new ResponseEntity<>(new Responses<UserResponseDto>(200, userResponse,
	            messageSource.getMessage("usermanagement.login.success", new Object[0], locale)),
	            HttpStatus.OK);
	}

}
