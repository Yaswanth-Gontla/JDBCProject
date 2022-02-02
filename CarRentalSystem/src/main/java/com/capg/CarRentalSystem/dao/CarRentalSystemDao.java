package com.capg.CarRentalSystem.dao;

import java.util.List;

import com.capg.CarRentalSystem.exception.WrongCredentialsException;

public interface CarRentalSystemDao 
{
	public String checkUser(String userName, String password) throws WrongCredentialsException;
	public List<List<String>> displayUsers();
	public List<List<String>> displayCarOrderdUsers();
	public List<List<String>> displayUsersandCarsOrdered();
	
	public List<String> printCompanies();
	public List<List<String>> searchByBrand(String company);
	public boolean increaseOrderCount(String userName,String carName, String carNumber);
	public boolean returnCar(String userName);
	
	public List<String> printFuelTypes();
	public List<List<String>> searchByFuelType(String fuel);
	
	public List<Integer> printSeatingCapacity();
	public List<List<String>> searchBySeatingCapacity(int capacity);
	
	public List<List<String>> searchByAvailability();
	
	public List<List<String>> viewOrders();
}
