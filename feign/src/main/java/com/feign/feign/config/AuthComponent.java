package com.feign.feign.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.feign.feign.dto.AuthRequestDTO;
import com.feign.feign.dto.AuthResponseDTO;
import com.feign.feign.service.FeignAuthService;
import com.feign.feign.utils.AppConstants;

@Component
public class AuthComponent {
	
	@Autowired
	FeignAuthService feignAuthService;
	
//	@PostConstruct
	public AuthResponseDTO authResponse() {
		AuthRequestDTO request = new AuthRequestDTO();
		request.setUserName(AppConstants.USER_NAME);
		request.setPassword(AppConstants.PASSWORD);
		AuthResponseDTO token = feignAuthService.authResponse(request);
		return token;
	}
}
