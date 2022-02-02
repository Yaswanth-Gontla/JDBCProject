package com.capg.CarRentalSystem.beans;

public class User {
	  private String user_name;
	  private String full_name;
	  private String password;
	  private String phone_number;
	  private String email;
	  private int total_orders;
	  private String role;
	  public User() {
	    super();
	  }
	  public User(String user_name, String full_name, String password, String phone_number, String email, int total_orders,
			String role) {
		this.user_name = user_name;
		this.full_name = full_name;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.total_orders = total_orders;
		this.role = role;
		}

		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getFull_name() {
			return full_name;
		}
		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getTotal_orders() {
			return total_orders;
		}
		public void setTotal_orders(int total_orders) {
			this.total_orders = total_orders;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		@Override
		public String toString() {
			return "User [user_name=" + user_name + ", full_name=" + full_name + ", password=" + password
					+ ", phone_number=" + phone_number + ", email=" + email + ", total_orders=" + total_orders + ", role="
					+ role + "]";
		}

	 
	}