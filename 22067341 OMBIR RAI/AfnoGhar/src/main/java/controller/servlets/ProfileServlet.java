package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.UserModel;
import utils.StringUtils;
import utils.ValidationUtil;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_PROFILE})
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbcontroller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
    	 this.dbcontroller = new DBController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String updateId = request.getParameter(StringUtils.UPDATE_ID);
		String deleteId = request.getParameter(StringUtils.DELETE_ID);
		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}
		System.out.println(updateId);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hello");
		String firstName = request.getParameter(StringUtils.FIRSTNAME);
        String lastName = request.getParameter(StringUtils.LASTNAME);
        LocalDate dob = LocalDate.parse(request.getParameter(StringUtils.DOB));
        String email = request.getParameter(StringUtils.EMAIL);
        String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
        String userName = request.getParameter(StringUtils.USERNAME);
        String address = request.getParameter(StringUtils.ADDRESS);
        
        UserModel profileModel = new UserModel(firstName, lastName ,dob, email, phoneNumber, userName, address);
			if(!ValidationUtil.isTextOnly(firstName) ||
					!ValidationUtil.isTextOnly(lastName) ||
					!ValidationUtil.isAlphanumeric(userName) ||
					!ValidationUtil.isEmail(email) ||
					!ValidationUtil.isNumbersOnly(phoneNumber) //||
					/**!ValidationUtil.isCateogry(category)**/){
				request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
				request.getRequestDispatcher(StringUtils.PAGE_URL_PROFILE).forward(request, response);
			}else {
				int result = dbcontroller.updateUser(profileModel);
				if (result == 1) {
					response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN+ "?success=true");
			}
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dodelete");
		String deleteId = request.getParameter(StringUtils.DELETE_ID);
		System.out.println(deleteId);
		int result = dbcontroller.deleteUser(deleteId);
		if (result == 1) {
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_SIGNUP);
		}
	}

}
