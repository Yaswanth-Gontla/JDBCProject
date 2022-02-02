package com.capg.CarRentalSystem.dao;

import java.util.List;

import com.capg.CarRentalSystem.beans.User;

public interface CarRentalSystemClientDao{
	public boolean insertAccount(User user) throws Exception;
	public List<List<String>> viewOrders(String userName);
	boolean checkUserName(String userName);
	boolean checkUserEmail(String userEmail);
}
