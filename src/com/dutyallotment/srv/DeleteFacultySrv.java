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
 * Servlet implementation class DeleteFacultySrv
 */
@WebServlet("/DeleteFacultySrv")
public class DeleteFacultySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection conn = null;
    public DeleteFacultySrv() {
        super();
        conn = DBUtil.getconnect();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int faculty_id = Integer.parseInt(request.getParameter("facultyid"));
		
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM FACULTY WHERE faculty_id = ?");
			ps.setInt(1, faculty_id);
			int i = ps.executeUpdate();
			
			if(i > 0) {
				response.sendRedirect("viewfaculty.jsp?status=3");
			}
			else {
				response.sendRedirect("viewfaculty.jsp?status=-1");
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
