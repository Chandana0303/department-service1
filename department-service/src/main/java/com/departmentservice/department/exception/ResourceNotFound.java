package com.departmentservice.department.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.ToString;

@ToString
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception {
	public ResourceNotFound(String message) 
	{
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
