package com.feign.feign.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserResponseDTO {
	
	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "firstName")
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String email;
	private Date createdOn;
	private String createdBy;
	private Date updatedOn;
	private String updatedBy;

}
