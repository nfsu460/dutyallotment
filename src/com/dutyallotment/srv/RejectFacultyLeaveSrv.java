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
 * Servlet implementation class RejectFacultyLeaveSrv
 */
@WebServlet("/RejectFacultyLeaveSrv")
public class RejectFacultyLeaveSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection conn = null;
    public RejectFacultyLeaveSrv() {
        super();
        conn = DBUtil.getconnect();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int l_id = Integer.parseInt(request.getParameter("lid"));
		
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE facultyleave SET l_approval = 0 WHERE l_id = ?");
			ps.setInt(1, l_id);
			int i = ps.executeUpdate();
			
			if(i > 0) {
				response.sendRedirect("approveleave.jsp?status=1");
			}
			else {
				response.sendRedirect("viewleave.jsp?status=-1");
			}
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
