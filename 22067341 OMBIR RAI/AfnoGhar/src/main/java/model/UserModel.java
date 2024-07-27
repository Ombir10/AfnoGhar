package model;

import java.time.LocalDate;

public class UserModel {

	private int userId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String category;
	private String email;
	private String phoneNumber;
	private String userName;
	private String address;
	private String password;


	public UserModel() {}

	public UserModel(int userId,String firstName, String lastName, String address, LocalDate dob, String category, String email,
			String phoneNumber, String userName, String password) {

		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.category = category;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public UserModel(String firstName, String lastName, LocalDate dob, String email, String phoneNumber,
				String userName, String address) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.dob = dob;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.userName = userName;
			this.address = address;
		}

	public UserModel(String firstName, String lastName, String address, LocalDate dob, String category, String email,
			String phoneNumber, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.category = category;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUSERNAME() {
		return userName;
	}

	public void setUSERNAME(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
