package com.capg.CarRentalSystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capg.CarRentalSystem.beans.User;
import com.capg.CarRentalSystem.util.DBConnection;

public class CarRentalSystemClientDaoImpl implements CarRentalSystemClientDao{

	Connection con = DBConnection.con;
	PreparedStatement ps; 
	Statement stmt;
	ResultSet rs;
	  
	public boolean insertAccount(User user) throws Exception {
		String sqlQuery = "insert into carrentalsystem.users values(?,?,?,?,?,?,?)";
	    try
	    {
	      ps = con.prepareStatement(sqlQuery);
	      ps.setString(1, user.getUser_name() );
	      ps.setString(3, user.getFull_name());
	      ps.setString(2, user.getPassword());
	      ps.setString(4, user.getPhone_number());
	      ps.setString(5, user.getEmail());
	      ps.setInt(6, user.getTotal_orders());
	      ps.setString(7, user.getRole());
	      int regStatus = ps.executeUpdate();
	      if(regStatus==1)
	    	  return true;
	      return false;
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return false;
	}

	public List<List<String>> viewOrders(String userName) {
		List<List<String>> allOrders = new ArrayList<List<String>>();
		List<String> order;
		
		String sqlQuery = "select * from carrentalsystem.orders where username=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
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

	public boolean checkUserName(String userName) {
		String sqlQuery = "select * from carrentalsystem.users where user_name=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count+=1;
			}
			if(count!=0)
				return false;
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	

	public boolean checkUserEmail(String userEmail) {
		String sqlQuery = "select * from carrentalsystem.users where email=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userEmail);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count+=1;
			}
			if(count!=0)
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
