package com.dutyallotment.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.bean.FacultyBean;
import com.dutyallotment.dao.FacultyDao;
import com.dutyallotment.dao.FacultyDaoImpl;


/**
 * Servlet implementation class RegisterCustomerSrv
 */
@WebServlet("/RegisterFacultySrv")
public class RegisterFacultySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFacultySrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String faculty_name=request.getParameter("faculty_name");
		String faculty_email=request.getParameter("faculty_email");
		String faculty_mobile = request.getParameter("faculty_mobile");
		String faculty_password=request.getParameter("faculty_password");
		
		FacultyDao dao = new FacultyDaoImpl();
		
		FacultyBean faculty = new FacultyBean();
		faculty.setFaculty_name(faculty_name);
		faculty.setFaculty_email(faculty_email);
		faculty.setFaculty_mobile(faculty_mobile);
		faculty.setFaculty_password(faculty_password);
		
		boolean flag = dao.registerFaculty(faculty);
		
		if(flag)
			response.sendRedirect("registerfaculty.jsp?status=1");	
		else
			response.sendRedirect("registerfaculty.jsp?status=-1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
