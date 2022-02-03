package com.capg.CarRentalSystem.service;

import java.util.List;
import java.util.Scanner;

import com.capg.CarRentalSystem.beans.User;
import com.capg.CarRentalSystem.dao.CarRentalSystemClientDao;
import com.capg.CarRentalSystem.dao.CarRentalSystemClientDaoImpl;
import com.capg.CarRentalSystem.dao.CarRentalSystemDao;
import com.capg.CarRentalSystem.dao.CarRentalSystemDaoImpl;
import com.capg.CarRentalSystem.exception.InvalidChoiceException;

public class CarRentalSystemClientServiceImpl implements CarRentalSystemClientService{
	
	static CarRentalSystemDao dao = new CarRentalSystemDaoImpl();
	static CarRentalSystemService service = new CarRentalSystemServiceImpl();
	static CarRentalSystemClientDao clientDao = new CarRentalSystemClientDaoImpl();
	static List<List<String>> allOrders;
	static int totalCount=0;
	Scanner sc = new Scanner(System.in);
	
	public boolean orderCar(String userName) throws Exception
	{
		try {
		System.out.println("1.Search By Brand\n2.Search By Fuel Type\n3.Search By Seating Capacity\n4.Search By Availability");
		int option = sc.nextInt();
		service.displayCar(option);
		int choice;
		totalCount = service.getTotalLength();
		if(option==1)
		{
			System.out.println("\nEnter SNO to book car else 0 to exit");
			choice = sc.nextInt();
			if(choice!=0)
			{
				if(choice>0 && choice<=totalCount)
				{
					String carName = service.getCarName(choice);
					String carNumber = service.getCarNumber(choice);
					boolean stat = dao.increaseOrderCount(userName,carName,carNumber);
					if(stat)
						return true;
					return false;
				}
				else
					throw new InvalidChoiceException();
			}
		}
		else if(option==2)
		{
			System.out.println("\nEnter SNO to book car else 0 to exit");
			choice = sc.nextInt();
			if(choice!=0)
			{
				if(choice>0 && choice<=totalCount)
				{
					
					String carName = service.getCarName(choice);
					String carNumber = service.getCarNumber(choice);
					boolean stat = dao.increaseOrderCount(userName,carName,carNumber);
					if(stat)
						return true;
					return false;
				}
				else
					throw new InvalidChoiceException();
			}
		}
		else if(option==3)
		{
			System.out.println("\nEnter SNO to book car else 0 to exit");
			choice = sc.nextInt();
			if(choice!=0)
			{
				if(choice>0 && choice<=totalCount)
				{
					String carName = service.getCarName(choice);
					String carNumber = service.getCarNumber(choice);
					boolean stat = dao.increaseOrderCount(userName,carName,carNumber);
					if(stat)
						return true;
					return false;
				}
				else
					throw new InvalidChoiceException();
			}
		}
		else if(option==4)
		{
			System.out.println("\nEnter SNO to book car else 0 to exit");
			choice = sc.nextInt();
			if(choice!=0)
			{
				if(choice>0 && choice<=totalCount)
				{
					String carName = service.getCarName(choice);
					String carNumber = service.getCarNumber(choice);
					boolean stat = dao.increaseOrderCount(userName,carName,carNumber);
					if(stat)
						return true;
					return false;
				}
				else
					throw new InvalidChoiceException();
			}
		}
	}
		catch(InvalidChoiceException err)
		{
			System.out.println(err.getErrorMsg());
		}
		
		return false;
	}
	
	
	public boolean insertAccount(User user) throws Exception {
		if(user!= null)
		{
			boolean isDataInserted = clientDao.insertAccount(user);
			return isDataInserted;
		}
		return false;
	}

	public void viewOrders(String userName) {
		allOrders = clientDao.viewOrders(userName);
		System.out.println("SNO\tUser Name\tModel Name\tCar Number");
		int cnt=1;
		if(allOrders.size()!=0)
		{
			for (List<String> list : allOrders) {
				System.out.print(cnt+"\t");
				for (int i = 0; i < list.size(); i++)
		            System.out.print(list.get(i) + "\t");
			cnt+=1;
			System.out.println();
			}
		}
		else
		{
			System.out.println("\n\n\nNo Orders...........");
		}
	}
	
	public boolean returnCar(String userName)
	{
		boolean stat = dao.returnCar(userName);
		return stat;
	}

	public boolean checkUserName(String userName) {
		
		return clientDao.checkUserName(userName);
	}

	public boolean checkUserEmail(String userEmail) {
		return clientDao.checkUserEmail(userEmail);
	}
	
}
