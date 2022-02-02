package com.capg.CarRentalSystem.exception;

@SuppressWarnings("serial")
public class InvalidMobileNumberException extends Exception {
	String errorMsg;
	public InvalidMobileNumberException()
	{
		this.errorMsg = "Mobile Number must be of 10 Digits";
	}
	public String getErrorMsg()
	{
		return this.errorMsg;
	}
}
