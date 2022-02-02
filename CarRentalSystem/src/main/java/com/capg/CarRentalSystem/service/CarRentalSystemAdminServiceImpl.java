package com.capg.CarRentalSystem.service;

import java.util.Scanner;

import com.capg.CarRentalSystem.beans.Car;
import com.capg.CarRentalSystem.dao.CarRentalSystemAdminDaoImpl;
import com.capg.CarRentalSystem.dao.CarRentalSystemAdminDao;

public class CarRentalSystemAdminServiceImpl implements CarRentalSystemAdminService {

	Scanner sc = new Scanner(System.in);
	Scanner s = new Scanner(System.in);
	CarRentalSystemAdminDao admindao = new CarRentalSystemAdminDaoImpl();
	
	public boolean insertCar(Car car) 
	{
		if(car!= null)
		{
			boolean isDataInserted = admindao.insertCar(car);
			return isDataInserted;
		}
		return false;
	}


	public boolean updateCar(int choice,String modelName) 
	{
		if(choice==1)
		{
			System.out.println("Enter Updated Price");
			int newCost = sc.nextInt();
			boolean stat = admindao.updateCarCost(modelName, newCost);
			return stat;
		}
		else if(choice==2)
		{
			System.out.println("Enter Availability");
			String availability = s.nextLine();
			boolean stat = admindao.updateCarAvailability(modelName,availability);
			return stat;
		}
		return false;
	}


	public boolean removeCar(String modelName) 
	{
		if(modelName!=null) {
		boolean isDeleted = admindao.removeCar(modelName);
		return isDeleted;
		}
		return false;
	}

}
