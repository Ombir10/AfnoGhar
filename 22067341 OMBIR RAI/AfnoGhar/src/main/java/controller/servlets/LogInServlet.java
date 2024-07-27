package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.LogInModel;
import model.UserModel;
import utils.StringUtils;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_LOGIN})
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbcontroller;
	private final UserModel userModel;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
		this.dbcontroller = new DBController();
		this.userModel = new UserModel();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter(StringUtils.USERNAME);
		String email = request.getParameter(StringUtils.EMAIL);
		String password = request.getParameter(StringUtils.PASSWORD);
	

			LogInModel loginModel = new LogInModel(email, password);
	
			int loginResult = dbcontroller.getLoginInfo(loginModel);
			System.out.println(loginResult);
			if (loginResult == 1) {
				// Login successful
				UserModel user = dbcontroller.getUserInfo(email);
				System.out.println(user.getUSERNAME());
				HttpSession userSession = request.getSession();
				userSession.setAttribute("email", user);
				userSession.setMaxInactiveInterval(2 * 30);
				
				Cookie userCookie = new Cookie("email", email);
				userCookie.setMaxAge(30 * 1);
				response.addCookie(userCookie);
				
				String category = dbcontroller.getCategory(email);
				System.out.println(category);
				
				if ("admin".equals(category)) {
				request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
				response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_ADMIN);
				}else if("customer".equals(category)) {
					request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
					response.sendRedirect(request.getContextPath() + StringUtils.URL_HOME);}
				
			} else if (loginResult == 0) {
				// Email or password mismatch
				request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
				request.setAttribute(StringUtils.EMAIL, email);
				request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
			} else if (loginResult == -1) {
				// Username not found
				request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
				request.setAttribute(StringUtils.EMAIL, email);
				request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
			} else {
				// Internal server error
				request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
				request.setAttribute(StringUtils.EMAIL, email);
				request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
			}
	}


}
