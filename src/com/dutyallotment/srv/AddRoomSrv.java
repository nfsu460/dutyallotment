package com.dutyallotment.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.bean.RoomBean;
import com.dutyallotment.dao.AdminDao;
import com.dutyallotment.dao.AdminDaoImpl;

/**
 * Servlet implementation class AddEmployeeSrv
 */
@WebServlet("/AddRoomSrv")
public class AddRoomSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		String r_department = request.getParameter("r_department");
		int r_strength = Integer.parseInt(request.getParameter("r_strength"));
		
		AdminDao dao = new AdminDaoImpl();
		
		RoomBean rb = new RoomBean(r_id, r_department, r_strength);
		
		boolean val = dao.addRoom(rb);
		
		if(val) {
			RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp?status=1");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("adminhome.jsp?status=-1");
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
