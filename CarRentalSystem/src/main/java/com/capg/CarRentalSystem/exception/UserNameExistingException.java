package com.capg.CarRentalSystem.exception;

@SuppressWarnings("serial")
public class UserNameExistingException extends Exception{
	
	String errorMsg;
	public UserNameExistingException()
	{
		this.errorMsg = "UserName already taken";
	}
	public String getErrorMsg()
	{
		return this.errorMsg;
	}
}
