package com.dutyallotment.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.dao.AdminDao;
import com.dutyallotment.dao.AdminDaoImpl;

/**
 * Servlet implementation class ApproveFacultySrv
 */
@WebServlet("/ApproveFacultySrv")
public class ApproveFacultySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveFacultySrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int faculty_id = Integer.parseInt(request.getParameter("id"));
		AdminDao dao = new AdminDaoImpl();
		boolean flag = dao.approveFaculty(faculty_id);
		
		if(flag) {
			RequestDispatcher rd = request.getRequestDispatcher("viewfaculty.jsp");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("approvefaculty.jsp?status=-1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
