package com.pms.usermanagement.service;

import java.util.List;
import java.util.Locale;

import com.pms.usermanagement.dto.EmailDtoVerfiy;
import com.pms.usermanagement.dto.SignupDto;
import com.pms.usermanagement.dto.UserDetailsDto;
import com.pms.usermanagement.enums.ModuleStatus;
import com.pms.usermanagement.model.Response;
import com.pms.usermanagement.model.User;

public interface UserService {

	Response<User> signupService(SignupDto signupDto,List<ModuleStatus> moduleStatus, Locale locale);

	







	

	



	





	

}
