package com.capg.CarRentalSystem.exception;

@SuppressWarnings("serial")
public class InvalidChoiceException extends Exception{
	String errorMsg;
	public InvalidChoiceException()
	{
		this.errorMsg = "Please select from the available options";
	}
	public String getErrorMsg()
	{
		return this.errorMsg;
	}
}
