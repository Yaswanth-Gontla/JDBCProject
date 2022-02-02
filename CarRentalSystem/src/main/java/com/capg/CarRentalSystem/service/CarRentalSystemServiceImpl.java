package com.capg.CarRentalSystem.service;

import java.util.List;
import java.util.Scanner;

import com.capg.CarRentalSystem.dao.CarRentalSystemDao;
import com.capg.CarRentalSystem.dao.CarRentalSystemDaoImpl;
import com.capg.CarRentalSystem.exception.InvalidChoiceException;
import com.capg.CarRentalSystem.exception.WrongCredentialsException;



public class CarRentalSystemServiceImpl implements CarRentalSystemService {
	Scanner sc = new Scanner(System.in);
	CarRentalSystemDao dao = new CarRentalSystemDaoImpl();
	static List<List<String>> userDetails;
	static List<List<String>> carBrands;
	static List<List<String>> allOrders;
	int totalLength,userChoice;
	
	public int getTotalLength()
	{
		return this.totalLength;
	}
	
	public int getUserChoice() {
		return this.userChoice;
	}
	
	public String checkUser(String userName, String password) throws WrongCredentialsException {
		if(userName!=null && password!=null)
		{
			String isCorrect = dao.checkUser(userName, password);
			return isCorrect;
		}
		return null;
	}
	
	public void displayUsers(int option) 
	{
		if(option==1)
		{
			userDetails = dao.displayUsers();
			System.out.println("SNO\tUserName\tFull Name\t\tPhoneNumber\tEmail\t\t\t\tTotalOrders");
			int cnt=1;
			for (List<String> list : userDetails) {
				System.out.print(cnt+"\t");
				System.out.print(list.get(0) + "\t");
				System.out.print(list.get(1) + "\t\t");
				System.out.print(list.get(2) + "\t");
				System.out.print(list.get(3) + "\t\t");
				System.out.print(list.get(4));
				cnt+=1;
				System.out.println();
			}
		}
		else if(option==2)
		{
			userDetails = dao.displayCarOrderdUsers();
			System.out.println("SNO\tUserName\tFull Name\t\tPhoneNumber\tEmail\t\t\t\tTotalOrders");
			int cnt=1;
			for (List<String> list : userDetails) {
				System.out.print(cnt+"\t");
				System.out.print(list.get(0) + "\t");
				System.out.print(list.get(1) + "\t\t");
				System.out.print(list.get(2) + "\t");
				System.out.print(list.get(3) + "\t\t");
				System.out.print(list.get(4));
				cnt+=1;
				System.out.println();
			}
		}
		else
		{
			userDetails = dao.displayUsersandCarsOrdered();
			System.out.println("SNO\tUserName\tTotalOrders");
			int cnt=1;
			for (List<String> list : userDetails) {
				System.out.print(cnt+"\t");
				System.out.print(list.get(0) + "\t");
				System.out.print(list.get(1));
				cnt+=1;
				System.out.println();
			}
		}
	}
	
	public void displayCar(int option) throws Exception
	{	
		try {
		if(option==1)
		{
			List<String> brands = dao.printCompanies();
			System.out.println("Companies");
			for (int i = 0; i < brands.size(); i++)
	            System.out.println((i+1)+" "+brands.get(i));
			System.out.println("Select Company");
			int choice = sc.nextInt();
			if(choice>0 && choice<=brands.size())
			{
				String company=brands.get(choice-1);
				carBrands = dao.searchByBrand(company);
				totalLength=carBrands.size();
				System.out.println("SNO\tComapny\tModel\tNumber\tFuel\tGear\tColor\tRate\tSeating\tAvailability");
				int cnt=1;
				if(carBrands.size()!=0)
				{
					for (List<String> list : carBrands) {
						System.out.print(cnt+"\t");
						for (int i = 0; i < list.size(); i++)
				            System.out.print(list.get(i) + "\t");
						cnt+=1;
						System.out.println();
					}
				}
				else
				{
					System.out.println("Currently No Cars Available............");
				}
			}
			else
				throw new InvalidChoiceException();
		}
		
		else if(option==2)
		{
			List<String> fuelTypes = dao.printFuelTypes();
			System.out.println("FuelTypes");
			for (int i = 0; i < fuelTypes.size(); i++)
	            System.out.println((i+1)+" "+fuelTypes.get(i));
			System.out.println("Select Fuel Type");
			int choice = sc.nextInt();
			if(choice>0 && choice<=fuelTypes.size())
			{
				String fuel = fuelTypes.get(choice-1);
				carBrands = dao.searchByFuelType(fuel);
				totalLength=carBrands.size();
				System.out.println("SNO\tComapny\tModel\tNumber\tFuel\tGear\tColor\tRate\tSeating\tAvailability");
				int cnt=1;
				if(carBrands.size()!=0)
				{
					for (List<String> list : carBrands) {
						System.out.print(cnt+"\t");
						for (int i = 0; i < list.size(); i++)
				            System.out.print(list.get(i) + "\t");
						cnt+=1;
						System.out.println();
					}
				}
				else
				{
					System.out.println("Currently No Cars Available............");
				}
				
			}
			else
				throw new InvalidChoiceException();
		}
		
		else if(option==3)
		{
			List<Integer> seatingCapacity = dao.printSeatingCapacity();
			System.out.println("Seating Capacity");
			//totalLength=seatingCapacity.size();
			for (int i = 0; i < seatingCapacity.size(); i++)
	            System.out.println((i+1)+" "+seatingCapacity.get(i));
			System.out.println("Select Seating Capacity");
			int choice = sc.nextInt();
			if(choice>0 && choice<=seatingCapacity.size())
			{
				int capacity = seatingCapacity.get(choice-1);
				
				int cnt=1;
				carBrands = dao.searchBySeatingCapacity(capacity);
				totalLength=carBrands.size();
				System.out.println("SNO\tComapny\tModel\tNumber\tFuel\tGear\tColor\tRate\tSeating\tAvailability");
				if(carBrands.size()!=0)
				{
					for (List<String> list : carBrands) {
						System.out.print(cnt+"\t");
						for (int i = 0; i < list.size(); i++)
				            System.out.print(list.get(i) + "\t");
						cnt+=1;
						System.out.println();
					}
				}
				else
				{
					System.out.println("Currently No Cars Available............");
				}
				
			}
			else
				throw new InvalidChoiceException();
		}
		
		else if(option==4)
		{
			int cnt=1;
			carBrands = dao.searchByAvailability();
			System.out.println("Based on Availability");
			totalLength=carBrands.size();
			System.out.println("SNO\tComapny\tModel\tNumber\tFuel\tGear\tColor\tRate\tSeating\tAvailability");
			if(carBrands.size()!=0)
			{
				for (List<String> list : carBrands) {
					System.out.print(cnt+"\t");
					for (int i = 0; i < list.size(); i++)
			            System.out.print(list.get(i) + "\t");
					cnt+=1;
					System.out.println();
				}
			}
			else
			{
				System.out.println("Currently No Cars Available............");
			}
		}
		}
		catch(InvalidChoiceException err)
		{
			System.out.println(err.getErrorMsg());
		}
	}
	
	
	public void viewOrders() {
		allOrders = dao.viewOrders();
		System.out.println("SNO\tUser Name\tModel Name\tCar Number");
		int cnt=1;
		for (List<String> list : allOrders) {
			System.out.print(cnt+"\t");
			for (int i = 0; i < list.size(); i++)
	            System.out.print(list.get(i) + "\t");
		cnt+=1;
		System.out.println();
		}
	}
	
	public String getCarNumber(int choice) {
		List<String> car = carBrands.get(choice-1);
		return car.get(2);
	}
	
	public String getCarName(int choice)
	{
		List<String> car = carBrands.get(choice-1);
		return car.get(1);
	}
}
