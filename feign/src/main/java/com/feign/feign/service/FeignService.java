package com.feign.feign.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "feign-service-producer", url = "")
public interface FeignService {

}
