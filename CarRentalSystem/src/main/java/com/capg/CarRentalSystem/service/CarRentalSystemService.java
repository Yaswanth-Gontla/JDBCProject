package com.capg.CarRentalSystem.service;

import com.capg.CarRentalSystem.exception.WrongCredentialsException;

public interface CarRentalSystemService 
{
	public String checkUser(String userName, String password)throws WrongCredentialsException;
	public void displayUsers(int option);
	public void displayCar(int option) throws Exception;
	public String getCarName(int choice);
	public String getCarNumber(int choice);
	public void viewOrders();
	public int getTotalLength();
	public int getUserChoice();
}
