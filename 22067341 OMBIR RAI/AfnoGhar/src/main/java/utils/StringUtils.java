package utils;

import java.io.File;

public class StringUtils {


	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/afnoghar";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	// End: DB Connection

	// Start: Queries
	public static final String REGISTER_QUERY = "INSERT INTO userprofile ("
			+ "FirstName, LastName, UserName, Category, ContactNumber, Address, Email, Password, DOB)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String REGISTER_ROOM_QUERY = "INSERT INTO room ("
			+ "HouseNumber, Address, HostNumber, UnitPrice)"
			+ "VALUES (?, ?, ?, ?)";

	public static final String GET_LOGIN_INFO = "SELECT * FROM userprofile WHERE Email = ?";

	public static final String QUERY_GET_ALL_USERS = "SELECT * FROM userprofile";
	
	public static final String QUERY_UPDATE_INFO = "UPDATE userprofile SET FirstName =?,LastName=?, UserName = ?, ContactNumber = ?,Address =?, DOB=?"+"WHERE Email = ?";
	
	public static final String QUERY_UPDATE_ROOM = "UPDATE room SET Address = ?, HostNumber = ?, UnitPrice = ?"+"WHERE HouseNumber =?";
	
	public static final String QUERY_USER_INFO = "SELECT * FROM userprofile "+" WHERE Email =?";
	
	public static final String QUERY_DELETE_USER = "DELETE FROM userprofile WHERE UserName = ?";
	
	public static final String QUERY_ROLE = "SELECT Category FROM userprofile WHERE Email =?";
	
	public static final String QUERY_GET_ALL_ROOMS = "SELECT * FROM room";
	
	public static final String QUERY_DELETE_ROOM = "DELETE FROM room WHERE HouseNumber = ?";
	// Start: Parameter names
	
	public static final String USERNAME = "userName";
	public static final String USER_NAME = "user_name";
	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";
	public static final String DOB = "dob";
	public static final String CATEGORY = "category";
	public static final String EMAIL = "email";
	public static final String PHONE_NUMBER = "number";
	public static final String PASSWORD = "password";
	public static final String ADDRESS = "address";
	public static final String RETYPE_PASSWORD = "retypePassword";
	public static final String  HOUSEID ="house_id";
	public static final String   HOUSENUMBER = "house_number";
	public static final String HOUSEADDRESS ="house_address";
	public static final String HOSTNUMBER ="host_number";
	public static final String UNITPRICE ="price";


	// Start: Validation Messages
	// Register Page Messages
	public static final String MESSAGE_SUCCESS_SIGNUP = "Successfully Registered!";
	public static final String MESSAGE_ERROR_SIGNUP = "Please correct the form data.";
	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";

	// Login Page Messages
	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

	public static final String SERVLET_URL_SIGNUP = "/signup";
	public static final String SERVLET_URL_LOGIN = "/login";
	public static final String SERVLET_URL_LOGOUT = "/logout";
	public static final String SERVLET_URL_PROFILE = "/profile";
	public static final String SERVLET_URL_ROOM = "/addroom";
	public static final String SERVLET_URL_ROOMS  ="/room";
	public static final String SERVLET_URL_MODFIY = "/modify";
	

	// Other Message
	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";		


	// Start: JSP Route
		public static final String PAGE_URL_LOGIN = "/pages/LogIn.jsp";
		public static final String PAGE_URL_SIGNUP = "/pages/SignUp.jsp";
		public static final String URL_HOME = "/home.jsp";
		public static final String PAGE_URL_HEADER = "/pages/header.jsp";
		public static final String PAGE_URL_ROOM = "/pages/Room.jsp";
		public static final String PAGE_URL_PROFILE = "/pages/profile.jsp";
		public static final String PAGE_URL_ADDROOM = "/pages/AddRoom.jsp";
		public static final String PAGE_URL_ADMIN = "/pages/adminheader.jsp";
		public static final String PAGE_URL_USER = "/pages/User.jsp";
		public static final String PAGE_URL_ROOM2 ="/pages/Room2.jsp";
		public static final String PAGE_URL_UPDATEPAGE ="/pages/update.jsp";
		public static final String PAGE_URL_HOME ="/pages/Home.jsp";

		public static final String USER = "user";
		public static final String SUCCESS = "success";
		public static final String TRUE = "true";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
		public static final String STUDENT_MODEL = "studentModel";
		public static final String DELETE_ID= "deleteId";
		public static final String UPDATE_ID= "updateId";
		public static final String ROOM_LISTS = "roomLists";
		// End: Servlet Route
		
		public static final String IMAGE_DIR = "xampp\\tomcat\\webapps\\images\\";
		public static final String IMAGE_DIR_SAVE_PATH ="C:" + File.separator + IMAGE_DIR;

}
