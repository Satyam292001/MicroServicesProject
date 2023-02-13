package com.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException()
	{
		super("resource not exit");
	}
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
