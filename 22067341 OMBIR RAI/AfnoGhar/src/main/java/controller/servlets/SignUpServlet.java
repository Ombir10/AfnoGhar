package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.UserModel;
import utils.StringUtils;
import utils.ValidationUtil;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_SIGNUP})
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbcontroller;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
    	this.dbcontroller = new DBController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			String firstName = request.getParameter(StringUtils.FIRSTNAME);
	        String lastName = request.getParameter(StringUtils.LASTNAME);
	        LocalDate dob = LocalDate.parse(request.getParameter(StringUtils.DOB));
	        String category = request.getParameter(StringUtils.CATEGORY);
	        String email = request.getParameter(StringUtils.EMAIL);
	        String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
	        String userName = request.getParameter(StringUtils.USERNAME);
	        String address = request.getParameter(StringUtils.ADDRESS);
	        String password = request.getParameter(StringUtils.PASSWORD);
	        
	        
	        //request.getRequestDispatcher(StringUtils.PAGE_URL_PROFILE).forward(request, response);



	        // Data Validation
			UserModel userModel = new UserModel(firstName, lastName, address,  dob,  category,  email,
					 phoneNumber,  userName,  password);
			if(!ValidationUtil.isTextOnly(firstName) ||
					!ValidationUtil.isTextOnly(lastName) ||
					!ValidationUtil.isAlphanumeric(userName) ||
					!ValidationUtil.isEmail(email) ||
					!ValidationUtil.isNumbersOnly(phoneNumber) //||
					/**!ValidationUtil.isCateogry(category)**/){
				request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
				request.getRequestDispatcher(StringUtils.PAGE_URL_SIGNUP).forward(request, response);
			}else {
				int result = dbcontroller.registerUser(userModel);
				if (result == 1) {
					response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN+ "?success=true");
			}
		}
	}
}
