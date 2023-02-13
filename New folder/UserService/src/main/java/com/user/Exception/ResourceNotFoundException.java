package com.user.Exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException()
	{
		super("resource not found");
	}
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
