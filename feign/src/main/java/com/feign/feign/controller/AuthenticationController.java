package com.feign.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign.feign.dto.AuthRequestDTO;
import com.feign.feign.dto.AuthResponseDTO;
import com.feign.feign.service.AuthenticationService;
import com.feign.feign.utils.AppResponse;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping(value = "/authenticate")
	public AppResponse<AuthResponseDTO> authenticatea(@RequestBody AuthRequestDTO authRequestDTO) {

		AuthResponseDTO authResponseDTO = authenticationService.loginCheck(authRequestDTO);
		if (authResponseDTO != null) {
			return AppResponse.<AuthResponseDTO>builder()
					.data(authResponseDTO)
					.message("Successfully authenticated user.")
					.success(true)
					.build();
		}
		return AppResponse.<AuthResponseDTO>builder()
				.success(false)
				.message("Authentication error, please check provided email or password!")
				.build();
	}
}
