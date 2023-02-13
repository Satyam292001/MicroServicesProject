package com.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotel.payload.ApiResponse;

public class HandlerResourceException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFoundException ex)
	{
		String message= ex.getMessage();
		ApiResponse response= ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
