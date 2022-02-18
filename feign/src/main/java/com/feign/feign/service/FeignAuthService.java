package com.feign.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.feign.feign.dto.AuthRequestDTO;
import com.feign.feign.dto.AuthResponseDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(value = "externalservice", url = "http://localhost:8083")
public interface FeignAuthService {
	
	@PostMapping("/authenticate")
	AuthResponseDTO authResponse(@RequestBody AuthRequestDTO request);
}
