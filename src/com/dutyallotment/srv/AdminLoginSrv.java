package com.dutyallotment.srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dutyallotment.dao.AdminDao;
import com.dutyallotment.dao.AdminDaoImpl;

/**
 * Servlet implementation class AdminLoginSrv
 */
@WebServlet("/AdminLoginSrv")
public class AdminLoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AdminDao dao=new AdminDaoImpl();
		
		boolean flag=dao.verifyAdmin(email.trim(), password.trim());
		
		if(flag) {
			HttpSession session = request.getSession();
		
			session.setAttribute("admin", 1);
			session.setAttribute("user_id",email);

		
			response.sendRedirect("adminhome.jsp");
		}
		else
			response.sendRedirect("adminlogin.jsp?status=-1");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
