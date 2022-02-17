package com.feign.feign.service;

import com.feign.feign.dto.AuthRequestDTO;
import com.feign.feign.dto.AuthResponseDTO;

public interface AuthenticationService {

	AuthResponseDTO loginCheck(AuthRequestDTO authRequestDTO);
}
