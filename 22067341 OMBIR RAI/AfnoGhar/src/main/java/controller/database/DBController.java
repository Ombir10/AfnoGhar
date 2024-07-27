package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LogInModel;
import model.RoomModel;
//import model.PassEncryptionWithAes;
import model.UserModel;
import utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DBController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(StringUtils.DRIVER_NAME);
		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	public int registerUser(UserModel user) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.REGISTER_QUERY);

			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setDate(9, Date.valueOf(user.getDob()));
			stmt.setString(4, user.getCategory());
			stmt.setString(7, user.getEmail());
			stmt.setString(5, user.getPhoneNumber());
			stmt.setString(3, user.getUSERNAME());
			stmt.setString(8, user.getPassword())/**PassEncryptionWithAes.encrypt(user.getUSERNAME(),user.getPassword()))**/;
			stmt.setString(6, user.getAddress());

			// Statement Run
			int result = stmt.executeUpdate();

			if (result > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public int registerRoom(RoomModel room) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.REGISTER_ROOM_QUERY);

			stmt.setInt(1, room.getHouse_number());
			stmt.setString(2, room.getAddress());
			stmt.setInt(3, room.getHost_number());
			stmt.setString(4, room.getUnit_price());

			// Statement Run
			int result = stmt.executeUpdate();

			if (result > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	

		public int getLoginInfo(LogInModel loginModel) {
			// Try-catch block to handle potential SQL or ClassNotFound exceptions
		    try {
		        // Prepare a statement using the predefined query for login check
		        PreparedStatement st = getConnection()
		        		.prepareStatement(StringUtils.GET_LOGIN_INFO);

		        // Set the username in the first parameter of the prepared statement
		        st.setString(1, loginModel.getEmail());

		        // Execute the query and store the result set
		        ResultSet result = st.executeQuery(	);


		        // Check if there's a record returned from the query
		        if (result.next()) {

		        	String userDb = result.getString(StringUtils.EMAIL);
		        	System.out.println(userDb);		        	//String passwordDb = result.getString(StringUtils.PASSWORD);

		            // Get the username from the database
		        	String encryptedPwd = result.getString(StringUtils.PASSWORD);
		        	System.out.println(encryptedPwd);

		            //String decryptedPwd = PassEncryptionWithAes.decrypt(encryptedPwd, userDb);
		            // Check if the username and password match the credentials from the database
		            if (userDb.equals(loginModel.getEmail())
		            		&& encryptedPwd.equals(loginModel.getPassword()))  {
		                // Login successful, return 1
		                return 1;
		            } else {
		                // Username or password mismatch, return 0
		                return 0;
		            }
		        } else {
		            // Username not found in the database, return -1
		            return -1;
		        }

		    // Catch SQLException and ClassNotFoundException if they occur
		    } catch (SQLException | ClassNotFoundException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        // Return -2 to indicate an internal error
		        return -2;
		    }
		}
		
		public String getCategory(String email) {
		try {
				PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_ROLE);

				stmt.setString(1, email);
				
				ResultSet result = stmt.executeQuery();
				// Statement Run
				
				
				if (result.next()) {
					
					 return result.getString(StringUtils.CATEGORY);
				} 
				else {
					return null;
				}
			} catch (ClassNotFoundException | SQLException ex) {
				ex.printStackTrace();
				return null;
			}
		} 
		
		public UserModel getUserInfo(String email) {
			UserModel userModel =null;
			try {
				PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_USER_INFO);
				stmt.setString(1, email);
				
				ResultSet result = stmt.executeQuery();
				
				if(result.next()) {
						userModel = new UserModel();
						userModel.setUserId(result.getInt(1));
						userModel.setFirstName(result.getString(2));
						userModel.setLastName(result.getString(3));
						userModel.setUSERNAME(result.getString(4));
						userModel.setCategory(result.getString(5));
						userModel.setPhoneNumber(result.getString(6));
						userModel.setAddress(result.getString(7));
						userModel.setEmail(result.getString(8));
						userModel.setPassword(result.getString(9));
						userModel.setDob(result.getDate(10).toLocalDate());
					}
				
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
		        // Return -2 to indicate an internal error
			}
			return userModel;
			
		}


			public ArrayList<UserModel> getAllUsersInfo(){
				try {
					PreparedStatement stmt = getConnection()
							.prepareStatement(StringUtils.QUERY_GET_ALL_USERS);
					ResultSet result = stmt.executeQuery();

					ArrayList<UserModel> users = new ArrayList<>();

					while(result.next()) {
						UserModel user = new UserModel();
						user.setFirstName(result.getString("first_name"));
						user.setLastName(result.getString("last_name"));
						user.setDob(result.getDate("birthday").toLocalDate());
						user.setEmail(result.getString("email"));
						user.setCategory(result.getString("category"));
						user.setPhoneNumber(result.getString("number"));


						users.add(user);
					}
					return users;
				}catch (SQLException | ClassNotFoundException ex) {
					ex.printStackTrace();
					return null;
				}
			}
			
			public ArrayList<RoomModel> getAllRoomInfo(){
					try {
						PreparedStatement stmt = getConnection()
								.prepareStatement(StringUtils.QUERY_GET_ALL_ROOMS);
						ResultSet result = stmt.executeQuery();
	
						ArrayList<RoomModel> rooms = new ArrayList<>();
	
						while(result.next()) {
							RoomModel room = new RoomModel();
							room.setHouse_number(result.getInt("HouseNumber"));
							room.setAddress(result.getString("Address"));
							//user.setDob(result.getDate("birthday").toLocalDate());
							room.setHost_number(result.getInt("HostNumber"));
							room.setUnit_price(result.getString("UnitPrice"));
							rooms.add(room);
						}
						return rooms;
					}catch (SQLException | ClassNotFoundException ex) {
						ex.printStackTrace();
						return null;
					}
				}
			
	public int updateUser(UserModel user) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_UPDATE_INFO);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setDate(6, Date.valueOf(user.getDob()));
			stmt.setString(7, user.getEmail());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(3, user.getUSERNAME());
			stmt.setString(5, user.getAddress());
			stmt.setString(8, user.getEmail());
			
			// Statement Run
			int rowUpdated = stmt.executeUpdate();
			
			if (rowUpdated > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	public int updateRoomInfo(RoomModel room) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_UPDATE_ROOM);
			//stmt.setInt(1, room.getDHouseNumber());
			stmt.setString(1, room.getAddress());
			stmt.setInt(2, room.getHost_number());
			stmt.setString(3, room.getUnit_price());
			stmt.setInt(4,room.getHouse_number());
			
			int update = stmt.executeUpdate();
			
			if (update > 0) {
				return 1;
			}else {
				return 0;
			}
		}
		catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
		
	}
	public int deleteUser(String userName) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_DELETE_USER);

			stmt.setString(1, userName);
			// Statement Run
			int rowUpdated = stmt.executeUpdate();
			
			if (rowUpdated > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}	
	
	public int deleteRoom(int homeNumber) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.QUERY_DELETE_ROOM);
			stmt.setInt(1, homeNumber);
			
			int delete = stmt.executeUpdate();
			
			if(delete > 0) {
				return 1;
			}else {
				return 0;
			}
		}
		 catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
}
