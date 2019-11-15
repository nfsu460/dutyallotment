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
 * Servlet implementation class ApproveLeaveSrv
 */
@WebServlet("/ApproveLeaveSrv")
public class ApproveLeaveSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveLeaveSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int l_id = Integer.parseInt(request.getParameter("id"));
		AdminDao dao = new AdminDaoImpl();
		boolean flag = dao.approveLeave(l_id);
		
		if(flag) {
			RequestDispatcher rd = request.getRequestDispatcher("viewleave.jsp");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("approveleave.jsp?status=-1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
