package com.dutyallotment.srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dutyallotment.dao.FacultyDao;
import com.dutyallotment.dao.FacultyDaoImpl;

/**
 * Servlet implementation class CustomerLoginSrv
 */
@WebServlet("/FacultyLoginSrv")
public class FacultyLoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyLoginSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String faculty_email = request.getParameter("faculty_email");
		String faculty_password=request.getParameter("faculty_password");
		
		FacultyDao dao = new FacultyDaoImpl();
		
		int faculty_id = dao.facultyLogin(faculty_email.trim(), faculty_password.trim());
		
		if(faculty_id > 0) {
			HttpSession session = request.getSession();
		
			session.setAttribute("faculty_id", faculty_id);
		
			response.sendRedirect("facultyhome.jsp");
		}
		else if(faculty_id == -1)
			response.sendRedirect("facultylogin.jsp?status=-1");
		
		else if(faculty_id == -2)
			response.sendRedirect("facultylogin.jsp?status=-2");
		else
			response.sendRedirect("facultylogin.jsp?status=0");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
