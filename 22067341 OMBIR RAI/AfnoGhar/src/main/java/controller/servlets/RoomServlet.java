package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.RoomModel;
import utils.StringUtils;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_ROOMS })
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbcontroller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
    	this.dbcontroller = new DBController();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<RoomModel> rooms = dbcontroller.getAllRoomInfo();
		request.setAttribute(StringUtils.ROOM_LISTS, rooms);
		request.getRequestDispatcher(StringUtils.PAGE_URL_ROOM).forward(request, response);
	}


}
