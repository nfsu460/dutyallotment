package com.dutyallotment.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.dao.FacultyDao;
import com.dutyallotment.dao.FacultyDaoImpl;


/**
 * Servlet implementation class CustomerChangePasswordSrv
 */
@WebServlet("/FacultyChangePasswordSrv")
public class FacultyChangePasswordSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyChangePasswordSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int faculty_id=Integer.parseInt(request.getParameter("faculty_id"));
		
		@SuppressWarnings("unused")
		String faculty_password=request.getParameter("faculty_password");
		
		String new_password=request.getParameter("new_password");
		String confirm_password=request.getParameter("confirm_password");
		
		if(new_password.equals(confirm_password)) {
			
			FacultyDao dao= new FacultyDaoImpl();
			boolean flag = dao.facultyChangePassword(faculty_id, new_password);
			
			if(flag) {
				
				request.setAttribute("faculty_id", faculty_id);
				
				RequestDispatcher rd=request.getRequestDispatcher("facultychangepasswordhome.jsp?status=1");
				rd.forward(request, response);
			}


			else
				request.setAttribute("faculty_id", faculty_id);
			
			RequestDispatcher rd=request.getRequestDispatcher("facultychangepasswordhome.jsp?status=-1");
			rd.forward(request, response);
			
		}
		else {
			request.setAttribute("faculty_id", faculty_id);
		
			RequestDispatcher rd=request.getRequestDispatcher("facultychangepasswordhome.jsp?status=-1");
			rd.forward(request, response);
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
