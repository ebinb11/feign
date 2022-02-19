package com.feign.feign.schedule;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.feign.feign.dto.AuthRequestDTO;
import com.feign.feign.dto.AuthResponseDTO;
import com.feign.feign.service.FeignAuthService;
import com.feign.feign.utils.AppConstants;

public class AuthSchedule {
	
	@Autowired
	FeignAuthService feignAuthService;
	
	@Autowired
	HttpSession session;
	
	@Scheduled(cron ="*/10 * * * * *" )
	public void authResponse() {
		AuthRequestDTO request = new AuthRequestDTO();
		request.setUserName(AppConstants.USER_NAME);
		request.setPassword(AppConstants.PASSWORD);
		AuthResponseDTO token = feignAuthService.authResponse(request);
		session.setAttribute("token", token.getToken());
		if (session.getAttribute("token") != null) {
			String sessionToken = (String) session.getAttribute("token");
		}
	}
}
