package com.capg.CarRentalSystem.dao;

import java.util.List;

import com.capg.CarRentalSystem.beans.Car;

public interface CarRentalSystemAdminDao 
{
	public boolean insertCar(Car car);
	public boolean removeCar(String modelName);
	public boolean updateCarCost(String modelName,int newCost);
	public boolean updateCarAvailability(String modelName,String availability);
	public List<List<String>> getDetails();	
}
