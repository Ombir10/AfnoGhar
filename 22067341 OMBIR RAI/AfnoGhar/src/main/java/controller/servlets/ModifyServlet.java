package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.RoomModel;
import utils.StringUtils;
import utils.ValidationUtil;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/modify" })
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbcontroller;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
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
		// TODO Auto-generated method stub
		
		System.out.println("Hello");
		String updateId = request.getParameter(StringUtils.UPDATE_ID);
		int house_number = Integer.parseInt(updateId);
		String address = request.getParameter(StringUtils.HOUSEADDRESS);
		int hostNumber = Integer.parseInt(request.getParameter(StringUtils.HOSTNUMBER));
		String unitPrice = request.getParameter(StringUtils.UNITPRICE);
		System.out.println(address + hostNumber + unitPrice);
		
		RoomModel roomModel = new RoomModel();
		roomModel.setHouse_number(house_number);
		roomModel.setAddress(address);
		roomModel.setHost_number(hostNumber);
		roomModel.setUnit_price(unitPrice);
		
		int result = dbcontroller.updateRoomInfo(roomModel);
		if(result == 1) {
			System.out.println("success");
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_ROOM2 +"?success= true");
		}else {
			System.out.println("not suces");
		}
	
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dodelete");
		int deleteId = Integer.parseInt(request.getParameter(StringUtils.DELETE_ID));
		System.out.println(deleteId);
		int result = dbcontroller.deleteRoom(deleteId);
		if (result == 1) {
			response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_ROOM2);
		}else {
			System.out.println("error");
		}
		
	}

}
