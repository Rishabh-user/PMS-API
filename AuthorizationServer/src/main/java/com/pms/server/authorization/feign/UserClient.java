package com.pms.server.authorization.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.pms.server.authorization.dto.EmailDtoVerfiy;
import com.pms.server.authorization.dto.UserDto;
import com.pms.server.authorization.dto.VerfiyPhoneDto;
import com.pms.server.authorization.dto.VerifyGoogleCodeDto;
import com.pms.server.authorization.dto.VerifyIpDTO;
import com.pms.server.authorization.dto.VerifySmsCodeDto;
import com.pms.server.authorization.model.DeviceTokenDetail;
import com.pms.server.authorization.model.LoginDetail;
import com.pms.server.authorization.model.Response;

@FeignClient(value = "${exchange.application.user-service}")
public interface UserClient {
	@GetMapping("/get-user")
	Response<UserDto> getUserByEmail(@RequestParam("email") String email);

	@GetMapping("/send-sms-code")
	Response<String> sendSmsCode(@RequestHeader("userId") Long userId);

	@PostMapping("/verify-sms-code")
	Response<VerfiyPhoneDto> verifySmsCode(@RequestHeader("userId") Long userId, VerifySmsCodeDto dto);

	@PostMapping("/verify-google-code")
	Response<String> verifyGoogleCode(@RequestHeader("userId") Long userId, VerifyGoogleCodeDto dto);

	@PostMapping("/save-login-detail")
	Response<Object> saveLoginDetail(@RequestHeader("userId") Long userId, LoginDetail loginDetail);

	@PostMapping("/send-ip-verify-mail")
	Response<Object> sendVerifyIpMail(@RequestBody VerifyIpDTO dto);

	@PostMapping("/save-device-token")
	Response<Object> saveDeviceTokenDetail(@RequestHeader("userId") Long userId,DeviceTokenDetail deviceTokenDetail);
	
	@GetMapping("/verify-user")
	public Response<EmailDtoVerfiy> verifyUser(@RequestParam String token);
}
