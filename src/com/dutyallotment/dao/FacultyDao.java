package com.dutyallotment.dao;

import java.util.List;

import com.dutyallotment.bean.ExamScheduleBean;
import com.dutyallotment.bean.FacultyBean;
import com.dutyallotment.bean.FacultyLeaveBean;
import com.dutyallotment.bean.FinalDutyAllotmentBean;

public interface FacultyDao {

	public boolean registerFaculty(FacultyBean faculty);
	public int facultyLogin(String faculty_email, String faculty_password);
	public int addLeave(int e_id, int faculty_id);
	public List<ExamScheduleBean> viewDateSheet();
	public List<FacultyLeaveBean> viewLeave(int faculty_id);
	public boolean facultyChangePassword(int faculty_id, String new_password);
	public List<FinalDutyAllotmentBean> viewAllotment(int faculty_id);

}
