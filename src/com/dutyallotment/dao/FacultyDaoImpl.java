package com.dutyallotment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dutyallotment.bean.ExamScheduleBean;
import com.dutyallotment.bean.FacultyBean;
import com.dutyallotment.bean.FacultyLeaveBean;
import com.dutyallotment.bean.FinalDutyAllotmentBean;
import com.dutyallotment.util.DBUtil;

public class FacultyDaoImpl implements FacultyDao {

	Connection conn = null;
	public FacultyDaoImpl() {
		// TODO Auto-generated constructor stub
		conn = DBUtil.getconnect();
	}

	@Override
	public boolean registerFaculty(FacultyBean faculty) {		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO faculty(faculty_name, faculty_email, faculty_mobile, faculty_password) VALUES(?, ?, ?, ?)");
			
			ps.setString(1, faculty.getFaculty_name());
			ps.setString(2, faculty.getFaculty_email());
			ps.setString(3, faculty.getFaculty_mobile());
			ps.setString(4, faculty.getFaculty_password());
			
			int temp = ps.executeUpdate();
			
			if(temp > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int facultyLogin(String faculty_email, String faculty_password) {
		int flag = -1;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM faculty WHERE faculty_email = ? AND faculty_password = ?");
			ps.setString(1, faculty_email);
			ps.setString(2, faculty_password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("faculty_approval") == 1) 
					flag = rs.getInt("faculty_id");
				else
					flag = -2;
			}
			else {
				flag = -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int addLeave(int e_id, int faculty_id) {
		String e_date = null;
		try {
			PreparedStatement ps = conn.prepareStatement("Select * from facultyleave where e_id = ? AND faculty_id = ?");
			ps.setInt(1, e_id);
			ps.setInt(2, faculty_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next()) {
				PreparedStatement ps1 = conn.prepareStatement("SELECT e_date FROM examschedule WHERE e_id = ?");
				ps1.setInt(1, e_id);
				
				ResultSet rs1 = ps1.executeQuery();
				
				if(rs1.next()) {
					e_date = rs1.getString("e_date");
				}
				else return -1;
			
				PreparedStatement ps2 = conn.prepareStatement("SELECT e_id FROM examschedule WHERE e_date LIKE ?");
				ps2.setString(1, e_date);
				ResultSet rs2 = ps2.executeQuery();

				while(rs2.next()) {
					PreparedStatement ps3 = conn.prepareStatement("INSERT INTO facultyleave(e_id, faculty_id) VALUES(?, ?)");
					ps3.setInt(1, rs2.getInt("e_id"));
					ps3.setInt(2, faculty_id);
					
					ps3.executeUpdate();
				}
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<ExamScheduleBean> viewDateSheet() {
		List<ExamScheduleBean> eBean = new ArrayList<ExamScheduleBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM examschedule");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				eBean.add(new ExamScheduleBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
			if(eBean.isEmpty()) eBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eBean;
	}

	@Override
	public List<FacultyLeaveBean> viewLeave(int faculty_id) {
		List<FacultyLeaveBean> eBean = new ArrayList<FacultyLeaveBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM facultyleave f, examschedule e where f.e_id = e.e_id AND faculty_id = ?");
			ps.setInt(1, faculty_id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				eBean.add(new FacultyLeaveBean(rs.getInt("l_id"), rs.getInt("faculty_id"), rs.getInt("e_id"), rs.getString("e_date"), rs.getInt("l_approval")));
			}
			
			if(eBean.isEmpty()) eBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eBean;
	}

	@Override
	public boolean facultyChangePassword(int faculty_id, String new_password) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE faculty SET faculty_password = ? WHERE faculty_id = ?");
			ps.setString(1, new_password);
			ps.setInt(2, faculty_id);
			
			int i = ps.executeUpdate();
			
			if(i > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<FinalDutyAllotmentBean> viewAllotment(int faculty_id) {
		
		List<FinalDutyAllotmentBean> fBean = new ArrayList<FinalDutyAllotmentBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT e.e_date, e.e_slot, a.r_id, f1.faculty_name, f2.faculty_name, e.e_subject FROM examschedule e, allotment a, faculty f1, faculty f2 WHERE a.e_id = e.e_id AND a.faculty_id1 = f1.faculty_id AND a.faculty_id2 = f2.faculty_id AND (a.faculty_id1 = ? OR a.faculty_id2 = ?)");
			ps.setInt(1, faculty_id);
			ps.setInt(2, faculty_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				fBean.add(new FinalDutyAllotmentBean(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			
			if(fBean.isEmpty()) fBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fBean;
	}

}
