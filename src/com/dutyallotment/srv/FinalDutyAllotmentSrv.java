package com.dutyallotment.srv;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dutyallotment.util.DBUtil;
import java.sql.Connection;

/**
 * Servlet implementation class FinalDutyAllotmentSrv
 */
@WebServlet("/FinalDutyAllotmentSrv")
public class FinalDutyAllotmentSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection conn = null;;
    public FinalDutyAllotmentSrv() {
        super();
        conn = DBUtil.getconnect();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int r_id = Integer.parseInt(request.getParameter("roomid"));
		int e_id = Integer.parseInt(request.getParameter("examid"));
		int faculty_id = Integer.parseInt(request.getParameter("facultyid"));
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from allotment where e_id = ? AND r_id = ?");
			ps.setInt(1, e_id);
			ps.setInt(2, r_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement update = conn.prepareStatement("UPDATE allotment SET faculty_id2 = ? where a_id = ?");
				update.setInt(1, faculty_id);
				update.setInt(2, rs.getInt("a_id"));
				
				int flag = update.executeUpdate();
				
				if(flag > 0) {
					PreparedStatement finalUpdate = conn.prepareStatement("UPDATE faculty SET faculty_availibility = 0 WHERE faculty_id = ?");
					finalUpdate.setInt(1, faculty_id);
					finalUpdate.executeUpdate();
				}
					
			}
			else {
				PreparedStatement ps2 = conn.prepareStatement("INSERT INTO allotment(e_id, faculty_id1, r_id) VALUES(?, ?, ?)");
				ps2.setInt(1, e_id);
				ps2.setInt(2, faculty_id);
				ps2.setInt(3, r_id);
				
				int flag = ps2.executeUpdate();
				
				if(flag > 0) {
					PreparedStatement finalUpdate = conn.prepareStatement("UPDATE faculty SET faculty_availibility = 0 WHERE faculty_id = ?");
					finalUpdate.setInt(1, faculty_id);
					
					finalUpdate.executeUpdate();
				}
			}
			
			response.sendRedirect("allotroom.jsp?examid="+e_id);
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
