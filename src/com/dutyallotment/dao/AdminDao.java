package com.dutyallotment.dao;

import java.util.List;

import com.dutyallotment.bean.ExamScheduleBean;
import com.dutyallotment.bean.FacultyBean;
import com.dutyallotment.bean.FacultyExamLeaveBean;
import com.dutyallotment.bean.FacultyLeaveBean;
import com.dutyallotment.bean.FinalDutyAllotmentBean;
import com.dutyallotment.bean.RoomBean;

public interface AdminDao {
	public boolean verifyAdmin(String admin_email, String admin_password);
	public boolean approveFaculty(int faculty_id);
	public boolean addRoom(RoomBean room);
	public List<RoomBean> viewRooms();
	public boolean addDateSheet(ExamScheduleBean examschedule);
	public List<ExamScheduleBean> viewDateSheet();
	public List<ExamScheduleBean> viewDateSheet1();
	public List<FacultyBean> viewApprovedFaculty();
	public List<FacultyBean> viewFinalFaculty(int e_id);
	public List<FacultyBean> viewPendingFaculty();
	public List<FacultyExamLeaveBean> viewApprovedLeave();
	public List<FacultyExamLeaveBean> viewPendingLeave();
	public boolean approveLeave(int l_id);
	public List<FinalDutyAllotmentBean> viewAllotment();
	
}
