package com.amizhth.inneer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amizhth.inneer.dto.AuthDTO;
import com.amizhth.inneer.service.AuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthDTO authDTO) {
		AuthDTO authOTPVerifyResponseModel = authService.login(authDTO);
		return ResponseEntity.ok().body(authOTPVerifyResponseModel);
	}

	@PostMapping("/password")
	public ResponseEntity<?> forgotPassword(@RequestBody AuthDTO authDTO) {
		AuthDTO authOTPVerifyResponseModel = authService.forgotPassword(authDTO);
		return ResponseEntity.ok().body(authOTPVerifyResponseModel);
	}

	@PostMapping("/otp")
	public ResponseEntity<?> confirmOTP(@RequestBody AuthDTO authDTO) {
		AuthDTO authOTPVerifyResponseModel = authService.confirmOTP(authDTO);
		return ResponseEntity.ok().body(authOTPVerifyResponseModel);
	}
}