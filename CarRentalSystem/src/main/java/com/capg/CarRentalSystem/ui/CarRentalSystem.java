package com.capg.CarRentalSystem.ui;

import java.util.Scanner;

import com.capg.CarRentalSystem.beans.Car;
import com.capg.CarRentalSystem.beans.User;
import com.capg.CarRentalSystem.exception.EmailExistingException;
import com.capg.CarRentalSystem.exception.InvalidMobileNumberException;
import com.capg.CarRentalSystem.exception.UserNameExistingException;
import com.capg.CarRentalSystem.service.CarRentalSystemAdminService;
import com.capg.CarRentalSystem.service.CarRentalSystemAdminServiceImpl;
import com.capg.CarRentalSystem.service.CarRentalSystemClientService;
import com.capg.CarRentalSystem.service.CarRentalSystemClientServiceImpl;
import com.capg.CarRentalSystem.service.CarRentalSystemService;
import com.capg.CarRentalSystem.service.CarRentalSystemServiceImpl;

public class CarRentalSystem 
{
	
	static Scanner sc = new Scanner(System.in);
	static Scanner s = new Scanner(System.in);
	static CarRentalSystemAdminService adminService = new CarRentalSystemAdminServiceImpl();
	static CarRentalSystemService service = new CarRentalSystemServiceImpl();
	static CarRentalSystemClientService clientService = new CarRentalSystemClientServiceImpl();

	public static void main(String[] args) throws Exception
	{
		try
		{
		System.out.println("Car Rental Systems");
		System.out.print("1.Register\n2.Login User\nEnter choice:");
		String userName,password;
		int ch = s.nextInt();
		if(ch==1)
		{
			System.out.println("Registering User.........");
			System.out.println("Enter username of your choice");
		    userName = sc.nextLine();
		    boolean userNameStatus = clientService.checkUserName(userName);
		    if(!(userNameStatus))
		    	throw new UserNameExistingException();
		    System.out.println("Enter your Full name");
		    String full_Name = sc.nextLine();
		    System.out.println("Enter Password of your choice");
		    password = sc.nextLine();
		    System.out.println("Enter email");	
		    String email = sc.nextLine();
		    boolean emailStatus = clientService.checkUserEmail(email);
		    if(!(emailStatus))
		    	throw new EmailExistingException();
		    System.out.println("Enter phone_number");
		    String phoneNumber = sc.nextLine();
		    if(phoneNumber.length()!=10)
		    	throw new InvalidMobileNumberException();
		    User reg = new User(userName,full_Name,password,phoneNumber,email,0,"client");
		    boolean regStatus = clientService.insertAccount(reg);
			System.out.println("User Created "+regStatus);
		}
		
		else
		{
			System.out.print("Enter User-Name:");
			userName = sc.nextLine();
			System.out.print("Enter Password:");
			password = sc.nextLine();
		}
		
		int option;
		String role = service.checkUser(userName, password);
		if(role!=null)
		{
			if(role.equalsIgnoreCase("admin"))
			{
				System.out.println("Sucessfully Logged in as Admin");
				
					
					boolean running = true;
					while(running)
					{
						System.out.println("1.Insert Car Details\n2.Delete a Car\n3.Update Car Details\n4.Display all Car Details\n5.Display User Details\n6.Display all Orders\n7.Exit");
						int choice = s.nextInt();
						switch(choice)
						{
						case 1:
							String brand,model,fuelType,gearType,color,availability,carNumber;
							int cost,seating;
							System.out.print("Enter Company:");
							brand = sc.nextLine();
							System.out.print("Enter Model Name:");
							model = sc.nextLine();
							System.out.print("Enter Car Number:");
							carNumber = sc.nextLine();
							System.out.print("Enter Fuel Type:");
							fuelType = sc.nextLine();
							System.out.print("Enter Gear Type:");
							gearType = sc.nextLine();
							System.out.print("Enter Color:");
							color = sc.nextLine();
							System.out.print("Enter Cost:");
							cost = s.nextInt();
							System.out.print("Enter Seating Capacity:");
							seating = s.nextInt();
							System.out.print("Enter Available or Not:");
							availability = sc.nextLine();
							Car c = new Car(brand,model,carNumber,fuelType,gearType,color,cost,seating,availability);
							boolean status = adminService.insertCar(c);
							System.out.println("Car Inserted "+status);
							break;
						case 2:
							boolean deletedStatus = adminService.removeCar("Alto");
							System.out.println("Car deleted "+deletedStatus);
							break;
						case 3:
							System.out.println("1.Update Price\n2.Update Availability");
							option = s.nextInt();
							System.out.println("Enter Model name to update details");
							String update = sc.nextLine();
							boolean updateStatus = adminService.updateCar(option,update);
							System.out.println("Car Details Updated "+updateStatus);
							break;
						case 4:
							System.out.println("1.Search By Brand\n2.Search By Fuel Type\n3.Search By Seating Capacity\n4.Search By Availability");
							System.out.println("Enter Choice");
							option = sc.nextInt();
							service.displayCar(option);
							break;
						case 5:
							System.out.println("1.Display all users\n2.Display based on No.Of Orders(Sorted)\n3.Display UserName and NoOf Orders");
							option = s.nextInt();
							service.displayUsers(option);
							break;
						case 6:
							System.out.println("All Orders");
							service.viewOrders();
							break;
						case 7:
							System.out.println("Application Closed Successfully");
							running = false;
							System.exit(0);
				    		break;
						}
				}
				
			}
			else if(role.equalsIgnoreCase("client"))
			{
				System.out.println("Sucessfully Logged in as Client");
				System.out.println("Welcome, "+userName);
				boolean running = true;
				while(running)
				{
					System.out.println("Choose the any one to proceed");
				    System.out.println("1.Order Car\n2.Return Car\n3.View Orders\n4.Exit");
				    int choice = s.nextInt();
				    switch(choice) {
				    case 1:
				    	boolean status = clientService.orderCar(userName);
						System.out.println("Car Ordered "+status);
						break;
				    case 2:
				    	boolean returnStatus = clientService.returnCar(userName);
				    	System.out.println("Return Status "+returnStatus);
				    	break;
				    case 3:
				    	System.out.println("View My Orders");
				    	clientService.viewOrders(userName);
				    	break;
				    case 4:
			    		System.out.println("Application Closed Successfully");
			    		running = false;
			    		System.exit(0);
			    		break;
				    }
				}
			}
		}
	}
		catch(UserNameExistingException e)
		{
			System.out.println(e.getErrorMsg());
		}
		catch(EmailExistingException e)
		{
			System.out.println(e.getErrorMsg());
		}
		catch(InvalidMobileNumberException e)
		{
			System.out.println(e.getErrorMsg());
		}
		
	}
}
