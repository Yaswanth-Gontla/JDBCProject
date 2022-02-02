package com.capg.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capg.CarRentalSystem.exception.WrongCredentialsException;
import com.capg.CarRentalSystem.util.DBConnection;

public class CarRentalSystemDaoImpl implements CarRentalSystemDao {

	Connection con = DBConnection.con;
	PreparedStatement ps,pst;
	static String orderedCar;
	static List<List<String>> carBrands;
	static List<String> cars;
	
	public String checkUser(String userName, String password) throws WrongCredentialsException{
		String sqlQuery = "select user_name,password,role from carrentalsystem.users";
		String userNames=null,passwords=null,role=null;
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while(rs.next())
			{
				userNames = rs.getString(1);
				passwords = rs.getString(2);
				
				if(userNames.equals(userName) && passwords.equals(password))
				{
					role = rs.getString(3);
					break;
				}
			}
			if(role==null)
				throw new WrongCredentialsException();
			return role;
		}
		
		catch(WrongCredentialsException userNameException)
		{
			System.out.println(userNameException.getErrorMsg());
		}
		catch(Exception e)
		{
			System.out.println("User not found "+e);
		}
		return null;
	}

	public List<List<String>> displayUsers() 
	{
		List<List<String>> userDetails = new ArrayList<List<String>>();
		List<String> users;
		String sqlQuery = "select * from carrentalsystem.users where role=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, "client");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				users = new ArrayList<String>();
				users.add(rs.getString(1));
				users.add(rs.getString(3));
				users.add(rs.getString(4));
				users.add(rs.getString(5));
				users.add(Integer.toString(rs.getInt(6)));
				userDetails.add(users);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userDetails;
	}

	public List<List<String>> displayCarOrderdUsers() 
	{
		List<List<String>> userDetails = new ArrayList<List<String>>();
		List<String> users;
		String sqlQuery = "select * from carrentalsystem.users where role=? order by total_orders desc";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, "client");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				users = new ArrayList<String>();
				users.add(rs.getString(1));
				users.add(rs.getString(3));
				users.add(rs.getString(4));
				users.add(rs.getString(5));
				int count = rs.getInt(6);
				users.add(Integer.toString(count));
				userDetails.add(users);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userDetails;
	}

	public List<List<String>> displayUsersandCarsOrdered() {
		List<List<String>> userDetails = new ArrayList<List<String>>();
		List<String> users;
		String sqlQuery = "select * from carrentalsystem.users where role=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, "client");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				users = new ArrayList<String>();
				users.add(rs.getString(1));
				int count = rs.getInt(6);
				users.add(Integer.toString(count));
				if(count!=0)
					userDetails.add(users);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userDetails;
	}

	public List<String> printCompanies() {
		List<String> companies = new ArrayList<String>();
		String sqlQuery = "select distinct company from carrentalsystem.cars";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				companies.add(rs.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return companies;
	}
	
	public List<List<String>> searchByBrand(String company) {
		
		String sqlQuery = "select * from carrentalsystem.cars where company=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, company);
			ResultSet rs = ps.executeQuery();
			carBrands = new ArrayList<List<String>>();
			while(rs.next())
			{
				
				cars = new ArrayList<String>();
				String brand = rs.getString(1);
				cars.add(brand);
				cars.add(rs.getString(2));
				cars.add(rs.getString(3));
				cars.add(rs.getString(4));
				cars.add(rs.getString(5));
				cars.add(rs.getString(6));
				int rate = rs.getInt(7);
				cars.add(Integer.toString(rate));
				int seatingCapacity = rs.getInt(8);
				cars.add(Integer.toString(seatingCapacity));
				String availability = rs.getString(9);
				cars.add(availability);
				
				if(brand.equals(company) && availability.equalsIgnoreCase("available"))
					carBrands.add(cars);
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return carBrands;
	}

	public List<String> printFuelTypes() {
		List<String> fueltypes = new ArrayList<String>();
		String sqlQuery = "select distinct fueltype from carrentalsystem.cars";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				fueltypes.add(rs.getString(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return fueltypes;
	}
	
	public List<List<String>> searchByFuelType(String fuel) {
		carBrands = new ArrayList<List<String>>();
		String sqlQuery = "select * from carrentalsystem.cars where fueltype=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, fuel);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				cars = new ArrayList<String>();
				cars.add(rs.getString(1));
				cars.add(rs.getString(2));
				cars.add(rs.getString(3));
				cars.add(rs.getString(4));
				cars.add(rs.getString(5));
				cars.add(rs.getString(6));
				int rate = rs.getInt(7);
				cars.add(Integer.toString(rate));
				int seatingCapacity = rs.getInt(8);
				cars.add(Integer.toString(seatingCapacity));
				String availability = rs.getString(9);
				cars.add(availability);
				
				if(availability.equalsIgnoreCase("available"))
					carBrands.add(cars);
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return carBrands;
	}

	public List<Integer> printSeatingCapacity() {
		List<Integer> seatingCapacity = new ArrayList<Integer>();
		String sqlQuery = "select distinct seatingcapacity fueltype from carrentalsystem.cars";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				seatingCapacity.add(rs.getInt(1));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return seatingCapacity;
	}
	public List<List<String>> searchBySeatingCapacity(int capacity) {
		String sqlQuery = "select * from carrentalsystem.cars where seatingcapacity=?";
		carBrands = new ArrayList<List<String>>();
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, capacity);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				cars = new ArrayList<String>();
				cars.add(rs.getString(1));
				cars.add(rs.getString(2));
				cars.add(rs.getString(3));
				cars.add(rs.getString(4));
				cars.add(rs.getString(5));
				cars.add(rs.getString(6));
				int rate = rs.getInt(7);
				cars.add(Integer.toString(rate));
				int seatingCapacity = rs.getInt(8);
				cars.add(Integer.toString(seatingCapacity));
				String availability = rs.getString(9);
				cars.add(availability);
				
				if(availability.equalsIgnoreCase("available"))
					carBrands.add(cars);
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return carBrands;
	}

	public List<List<String>> searchByAvailability() {
		String sqlQuery = "select * from carrentalsystem.cars where availability=?";
		carBrands = new ArrayList<List<String>>();
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1,"Available");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				cars = new ArrayList<String>();
				cars.add(rs.getString(1));
				cars.add(rs.getString(2));
				cars.add(rs.getString(3));
				cars.add(rs.getString(4));
				cars.add(rs.getString(5));
				cars.add(rs.getString(6));
				int rate = rs.getInt(7);
				cars.add(Integer.toString(rate));
				int seatingCapacity = rs.getInt(8);
				cars.add(Integer.toString(seatingCapacity));
				String availability = rs.getString(9);
				cars.add(availability);
				carBrands.add(cars);
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return carBrands;
	}

	public boolean increaseOrderCount(String userName,String carName, String carNumber) 
	{
		
		String sqlQuery = "select * from carrentalsystem.users where user_name=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			int count=-1;
			while(rs.next())
			{
				count = rs.getInt(6);
			}
			count+=1;

			String sqlQueries = "update carrentalsystem.users set total_orders =? where user_name=?";
			pst = con.prepareStatement(sqlQueries);
			
			pst.setInt(1,count);
			pst.setString(2,userName);
			
			int i = pst.executeUpdate();
			
			String sqlQuerie = "insert into carrentalsystem.orders values(?,?,?)";
			pst = con.prepareStatement(sqlQuerie);
			pst.setString(1,userName);
			pst.setString(2,carName);
			pst.setString(3,carNumber);
			
			int j = pst.executeUpdate();
			
			String sql = "update carrentalsystem.cars set availability =? where modelname=?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1,"Not Available");
			pst.setString(2,carName);
			pst.executeUpdate();
			if(i==1 && j==1)
				return true;
			return false;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	public List<List<String>> viewOrders() {
		List<List<String>> allOrders = new ArrayList<List<String>>();
		List<String> order;
		
		String sqlQuery = "select * from carrentalsystem.orders";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				order = new ArrayList<String>();
				order.add(rs.getString(1));
				order.add(rs.getString(2));
				order.add(rs.getString(3));
				allOrders.add(order);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return allOrders;
	}

	public boolean returnCar(String userName) {
		String sqlQuery = "select * from carrentalsystem.orders where username=?";
		
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			String carName="",carNumber="",user;
			while(rs.next())
			{
				user=rs.getString(1);
				carName = rs.getString(2);
				carNumber = rs.getString(3);
			}
			sqlQuery = "delete from carrentalsystem.orders where username = ?";
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			int i = ps.executeUpdate();
			if(i==1)
			{
				String sql = "update carrentalsystem.cars set availability =? where carnumber=?";
				pst = con.prepareStatement(sql);
				pst.setString(1,"Available");
				pst.setString(2,carNumber);
				pst.executeUpdate();
			}
			else
				return false;
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
	}


	

	

}
