package com.capg.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.capg.CarRentalSystem.beans.Car;
import com.capg.CarRentalSystem.util.DBConnection;



public class CarRentalSystemAdminDaoImpl implements CarRentalSystemAdminDao {
	
	Connection con = DBConnection.con;
	PreparedStatement ps;

	public boolean insertCar(Car car) 
	{
		String sqlQuery = "insert into carrentalsystem.cars values(?,?,?,?,?,?,?,?,?)";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, car.getCompany());
			ps.setString(2, car.getModelName());
			ps.setString(3, car.getCarNumber());
			ps.setString(4, car.getFuelType());
			ps.setString(5, car.getGearType());
			ps.setString(6, car.getColor());
			ps.setInt(7, car.getRate());
			ps.setInt(8, car.getSeatingCapacity());
			ps.setString(9, car.getAvailability());
			
			int i = ps.executeUpdate();
			if(i==1) 
				return true;
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Eception while Data Insertion "+e);
		}
		return false;
	}

	public boolean removeCar(String modelName)
	{
		String sqlQuery = "delete from carrentalsystem.cars where modelName = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, modelName);
			int i = ps.executeUpdate();
			if(i==1)
				return true;
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Error while deleting "+e);
		}
		return false;
		
	}


	public List<List<String>> getDetails() 
	{
		List<List<String>> carDetails = new ArrayList<List<String>>();
		List<String> cars;
		String sqlQuery = "select * from carrentalsystem.cars";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				cars = new ArrayList<String>();
				cars.add(rs.getString(1));
				cars.add(rs.getString(3));
				cars.add(rs.getString(4));
				cars.add(rs.getString(5));
				cars.add(Integer.toString(rs.getInt(6)));
				carDetails.add(cars);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return carDetails;
	}
	
	public boolean updateCarCost(String modelName,int newCost) 
	{
		String sqlQuery = "update carrentalsystem.cars set rate =? where modelname=?";
		try
		{
		ps = con.prepareStatement(sqlQuery);
		ps.setInt(1,newCost);
		ps.setString(2,modelName);
		int i = ps.executeUpdate();
		if(i==1)
			return true;
		return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	public boolean updateCarAvailability(String modelName, String availability) 
	{
		String sqlQuery = "update carrentalsystem.cars set availability =? where modelname=?";
		try
		{
		ps = con.prepareStatement(sqlQuery);
		ps.setString(1,availability);
		ps.setString(2,modelName);
		int i = ps.executeUpdate();
		if(i==1)
			return true;
		return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

}
