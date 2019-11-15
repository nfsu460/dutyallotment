package com.dutyallotment.srv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.util.DBUtil;

/**
 * Servlet implementation class SubmitSrv
 */
@WebServlet("/SubmitSrv")
public class SubmitSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection conn = null;
    public SubmitSrv() {
        super();
        conn = DBUtil.getconnect();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int e_id = Integer.parseInt(request.getParameter("eid"));
		try {
	
			PreparedStatement ps1 = conn.prepareStatement("UPDATE faculty SET faculty_availibility = 1");
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement("UPDATE examschedule SET e_status = 0 where e_id = ?");
			ps2.setInt(1, e_id);
			ps2.executeUpdate();
			
			response.sendRedirect("allotduty.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
