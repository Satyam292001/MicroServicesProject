package com.user.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException()
	{
		super("resouce not exit");
	}
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
