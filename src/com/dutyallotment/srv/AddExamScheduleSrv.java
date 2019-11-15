package com.dutyallotment.srv;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.bean.ExamScheduleBean;
import com.dutyallotment.dao.AdminDao;
import com.dutyallotment.dao.AdminDaoImpl;

/**
 * Servlet implementation class AddEmployeeSrv
 */
@WebServlet("/AddExamScheduleSrv")
public class AddExamScheduleSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamScheduleSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String e_date = request.getParameter("e_date");
		String e_subject = request.getParameter("e_subject");
		String e_slot = request.getParameter("e_slot");
		
		AdminDao dao = new AdminDaoImpl();
		
		ExamScheduleBean eb = new ExamScheduleBean();
		eb.setE_date(e_date);
		eb.setE_subject(e_subject);
		eb.setE_slot(e_slot);
		
		boolean val = dao.addDateSheet(eb);
		
		if(val) {
			RequestDispatcher rd = request.getRequestDispatcher("addexamschedule.jsp?status=1");
			rd.forward(request, response);
		}
		else
			response.sendRedirect("addexamschedule.jsp?status=-1");
			
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
