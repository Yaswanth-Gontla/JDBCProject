package com.capg.CarRentalSystem.service;

import com.capg.CarRentalSystem.beans.Car;

public interface CarRentalSystemAdminService 
{
	public boolean insertCar(Car car);
	public boolean removeCar(String modelName);
	public boolean updateCar(int choice,String modelName);
	
}
