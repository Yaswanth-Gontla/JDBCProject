package com.capg.CarRentalSystem.exception;

@SuppressWarnings("serial")
public class WrongCredentialsException extends Exception 
{
	String errorMsg;
	public WrongCredentialsException()
	{
		this.errorMsg = "You have entered Wrong UserName/Password";
	}
	public String getErrorMsg()
	{
		return this.errorMsg;
	}
}
