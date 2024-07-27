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
 * Servlet implementation class RooServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.SERVLET_URL_ROOM})
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbcontroller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
    	this.dbcontroller = new DBController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			int houseNumber = Integer.parseInt(request.getParameter(StringUtils.HOUSENUMBER));
			String address = request.getParameter(StringUtils.HOUSEADDRESS);
			int hostNumber = Integer.parseInt(request.getParameter(StringUtils.HOSTNUMBER));
			String unitPrice = request.getParameter(StringUtils.UNITPRICE);
			System.out.println(request.getParameter(StringUtils.HOSTNUMBER));
			System.out.println(request.getParameter(StringUtils.HOUSEADDRESS));
			System.out.println(request.getParameter(StringUtils.HOUSENUMBER));
			System.out.println(request.getParameter(StringUtils.UNITPRICE));
			
			ArrayList<RoomModel> room = dbcontroller.getAllRoomInfo();
			System.out.println(room);
			RoomModel  roomModel = new RoomModel(houseNumber, address, hostNumber, unitPrice);
			
			int result = dbcontroller.registerRoom(roomModel);
			if(result == 1) {
				response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_ROOM);
			}
			
		}
	}

