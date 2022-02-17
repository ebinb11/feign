package com.feign.feign.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.feign.feign.dto.AuthRequestDTO;
import com.feign.feign.dto.AuthResponseDTO;
import com.feign.feign.entity.User;
import com.feign.feign.security.JwtTokenUtil;
import com.feign.feign.service.AuthenticationService;
import com.feign.feign.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	PasswordEncoder PasswordEncoder;

	@Override
	public AuthResponseDTO loginCheck(AuthRequestDTO authRequestDTO) {
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUserName(), authRequestDTO.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		AuthResponseDTO response = new AuthResponseDTO();
		final User user = userService.findUserByEmailAddress(authRequestDTO.getUserName());
		if (user != null) {
			if (PasswordEncoder.matches(authRequestDTO.getPassword(), user.getPassword())) {
				final String token = jwtTokenUtil.generateToken(user.getEmail());
				response.setToken(token);
				return response;
			}
		}
		throw new BadCredentialsException("Authentication error, please check provided email or password!");
	}
}
