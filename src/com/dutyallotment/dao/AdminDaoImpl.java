package com.dutyallotment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dutyallotment.bean.ExamScheduleBean;
import com.dutyallotment.bean.FacultyBean;
import com.dutyallotment.bean.FacultyExamLeaveBean;
import com.dutyallotment.bean.FacultyLeaveBean;
import com.dutyallotment.bean.FinalDutyAllotmentBean;
import com.dutyallotment.bean.RoomBean;
import com.dutyallotment.util.DBUtil;

public class AdminDaoImpl implements AdminDao {
	
	Connection conn = null;
	
	public AdminDaoImpl() {
		conn = DBUtil.getconnect();
	}

	@Override
	public boolean verifyAdmin(String admin_email, String admin_password) {
		
		String email = "admin@dutyallotment.com";
		String password = "admin";
		
		if(admin_email.equals(email) && admin_password.equals(password)) 
			return true;
		
		return false;
	}

	@Override
	public boolean approveFaculty(int faculty_id) {
			
		try {
			PreparedStatement ps = conn.prepareStatement("update faculty set faculty_approval = 1 where faculty_id = ?");
			ps.setInt(1, faculty_id);
				
			int i = ps.executeUpdate();
				
			if(i > 0)
				return true;
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addRoom(RoomBean room) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into room(r_id, r_department, r_strength) values(?, ?, ?)");
			ps.setInt(1, room.getR_id());
			ps.setString(2, room.getR_department());
			ps.setInt(3, room.getR_strength());
			
			int i = ps.executeUpdate();
			
			if(i > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addDateSheet(ExamScheduleBean examschedule) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into examschedule(e_date, e_subject, e_slot) values(?, ?, ?)");
			ps.setString(1, examschedule.getE_date());
			ps.setString(2, examschedule.getE_subject());
			ps.setString(3, examschedule.getE_slot());
			
			int i = ps.executeUpdate();
			
			if(i > 0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean approveLeave(int l_id) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("update facultyleave set l_approval = 1 where l_id = ?");
			
			ps.setInt(1, l_id);
			
			int i = ps.executeUpdate();
			
			if(i > 0)
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<RoomBean> viewRooms() {
		List<RoomBean> rBean = new ArrayList<RoomBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM room");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				rBean.add(new RoomBean(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			
			if(rBean.isEmpty()) rBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rBean;
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
	public List<FacultyBean> viewApprovedFaculty() {
		List<FacultyBean> fBean = new ArrayList<FacultyBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM faculty where faculty_approval = 1");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				fBean.add(new FacultyBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
			
			if(fBean.isEmpty()) fBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fBean;
	}

	@Override
	public List<FacultyBean> viewPendingFaculty() {
		List<FacultyBean> fBean = new ArrayList<FacultyBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM faculty where faculty_approval = 0");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				fBean.add(new FacultyBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
			
			if(fBean.isEmpty()) fBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fBean;
	}

	@Override
	public List<FacultyExamLeaveBean> viewApprovedLeave() {
		
		List<FacultyExamLeaveBean> felBean = new ArrayList<FacultyExamLeaveBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM facultyleave fl, faculty f, examschedule e where fl.l_approval = 1 AND fl.faculty_id = f.faculty_id AND fl.e_id = e.e_id");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				felBean.add(new FacultyExamLeaveBean(rs.getInt("l_id"), rs.getInt("faculty_id"), rs.getString("faculty_name"), rs.getInt("e_id"), rs.getString("e_date")));
			}
			
			if(felBean.isEmpty()) felBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return felBean;
	}

	@Override
	public List<FacultyExamLeaveBean> viewPendingLeave() {
		List<FacultyExamLeaveBean> felBean = new ArrayList<FacultyExamLeaveBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM facultyleave fl, faculty f, examschedule e where fl.l_approval = 0 AND fl.faculty_id = f.faculty_id AND fl.e_id = e.e_id");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				felBean.add(new FacultyExamLeaveBean(rs.getInt("l_id"), rs.getInt("faculty_id"), rs.getString("faculty_name"), rs.getInt("e_id"), rs.getString("e_date")));
			}
			
			if(felBean.isEmpty()) felBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return felBean;
	}

	@Override
	public List<FacultyBean> viewFinalFaculty(int e_id) {
		
		List<FacultyBean> fBean = new ArrayList<FacultyBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from faculty f where f.faculty_approval = 1 AND f.faculty_availibility = 1 AND faculty_id NOT IN (Select l.faculty_id from facultyleave l where l_approval = 1 AND e_id = ?)");
			ps.setInt(1, e_id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				fBean.add(new FacultyBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
			
			if(fBean.isEmpty()) fBean = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fBean;
	}

	@Override
	public List<FinalDutyAllotmentBean> viewAllotment() {
		
		List<FinalDutyAllotmentBean> fBean = new ArrayList<FinalDutyAllotmentBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT e.e_date, e.e_slot, a.r_id, f1.faculty_name, f2.faculty_name, e.e_subject FROM examschedule e, allotment a, faculty f1, faculty f2 WHERE a.e_id = e.e_id AND a.faculty_id1 = f1.faculty_id AND a.faculty_id2 = f2.faculty_id");
			
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

	@Override
	public List<ExamScheduleBean> viewDateSheet1() {
		List<ExamScheduleBean> eBean = new ArrayList<ExamScheduleBean>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM examschedule WHERE e_status = 1");
			
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
	
	
}
