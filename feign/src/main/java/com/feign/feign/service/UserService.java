package com.feign.feign.service;

import org.springframework.data.domain.Sort.Direction;

import com.feign.feign.dto.StatusResponse;
import com.feign.feign.dto.UserListResponseDTO;
import com.feign.feign.dto.UserRequestDTO;
import com.feign.feign.dto.UserResponseDTO;
import com.feign.feign.entity.User;

public interface UserService {

	User findUserByEmailAddress(final String userName); 
	
	UserListResponseDTO getUserList(Integer page, Integer size, String search, Direction sort, Long id);

	UserResponseDTO userEntry(UserRequestDTO request);

	UserResponseDTO userGetById(Long id);

	StatusResponse deleteUser(Long id);

}
