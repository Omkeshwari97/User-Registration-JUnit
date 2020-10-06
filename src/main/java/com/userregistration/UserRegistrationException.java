package com.userregistration;

public class UserRegistrationException extends Exception
{
	enum ExceptionType
	{
		FIRST_NAME, LAST_NAME, EMAIL, MOBILE_NUMBER, PASSWORD;
	}
	
	ExceptionType type;
	
	public UserRegistrationException(ExceptionType type, String message) 
	{
		super(message);
		this.type=type;
	}
	
	public ExceptionType getType()
	{
		return type;
	}
}
