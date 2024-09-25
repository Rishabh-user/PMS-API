package com.pms.usermanagement.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.usermanagement.dto.SignupDto;
import com.pms.usermanagement.enums.ModuleStatus;
import com.pms.usermanagement.model.Module;
import com.pms.usermanagement.model.Response;
import com.pms.usermanagement.model.User;
import com.pms.usermanagement.service.ModuleService;
import com.pms.usermanagement.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModuleService moduleService;



	@ApiOperation(value = "API for signUp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 200, message = "Unable to send email"),
			@ApiResponse(code = 205, message = "Email already registered"),
			@ApiResponse(code = 205, message = "Phone number already registered"), })
	@PostMapping("/signup")
	public Response<User> signup(@Valid @RequestBody SignupDto signupDto,@RequestParam(required = false) List<ModuleStatus> moduleStatus, Locale locale) {
		return userService.signupService(signupDto,moduleStatus, locale);
	}
	
	
	  @PostMapping("/add-module")
	    public ResponseEntity<Module> addModule(@RequestBody Module module) {
	        Module savedModule = moduleService.saveModule(module);
	        return ResponseEntity.ok(savedModule);
	    }
	
	
}
