package com.feign.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.feign.feign.dto.UserResponseDTO;

@FeignClient(value = "feign-service-producer", url = "http://localhost:8083/api")
public interface FeignService {
	
	@GetMapping("user/feignService")
	String hello();

	@GetMapping("user/getById/{id}")
	UserResponseDTO userGetById(@PathVariable("id") Long id);
}
