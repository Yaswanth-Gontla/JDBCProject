package com.capg.CarRentalSystem.service;

import com.capg.CarRentalSystem.beans.User;

public interface CarRentalSystemClientService 
{
	public boolean orderCar(String userName) throws Exception;
	public boolean returnCar(String userName);
	public boolean insertAccount(User user) throws Exception;
	public void viewOrders(String userName);
	boolean checkUserName(String userName);
	boolean checkUserEmail(String userEmail);
}