package com.capg.CarRentalSystem.beans;

public class Car 
{
	private String loggedInUser;
	private String company;
	private int rate;
	private String fuelType;
	private int seatingCapacity;
	private String gearType;
	private String color;
	private String modelName;
	private String availability;
	private String carNumber;
	public Car() {
		super();
	}
	
	public Car(String loggedInUser)
	{
		super();
		this.loggedInUser = loggedInUser;
	}
	
	public Car(String company, String modelName, String carNumber,String fuelType, String gearType, String color, int rate, int seatingCapacity,String availability) {
		super();
		this.company = company;
		this.modelName = modelName;
		this.carNumber = carNumber;
		this.rate = rate;
		this.fuelType = fuelType;
		this.seatingCapacity = seatingCapacity;
		this.gearType = gearType;
		this.color = color;
		this.availability = availability;
	}

	public String getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
