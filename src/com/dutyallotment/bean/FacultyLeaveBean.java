package com.dutyallotment.bean;

import java.io.Serializable;

public class FacultyLeaveBean implements Serializable {
	private int l_id;
	private int faculty_id;
	private int e_id;
	private String e_date;
	private int l_approval;
	

	public FacultyLeaveBean() {
		// TODO Auto-generated constructor stub
	}


	public FacultyLeaveBean(int l_id, int faculty_id, int e_id, int l_approval) {
		super();
		this.l_id = l_id;
		this.faculty_id = faculty_id;
		this.e_id = e_id;
		this.l_approval=l_approval;
	}


	public int getL_id() {
		return l_id;
	}


	public void setL_id(int l_id) {
		this.l_id = l_id;
	}


	public int getFaculty_id() {
		return faculty_id;
	}


	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}


	public int getE_id() {
		return e_id;
	}


	public void setE_id(int e_id) {
		this.e_id = e_id;
	}


	public int getL_approval() {
		return l_approval;
	}


	public void setL_approval(int l_approval) {
		this.l_approval = l_approval;
	}


	public String getE_date() {
		return e_date;
	}


	public void setE_date(String e_date) {
		this.e_date = e_date;
	}


	public FacultyLeaveBean(int l_id, int faculty_id, int e_id, String e_date, int l_approval) {
		super();
		this.l_id = l_id;
		this.faculty_id = faculty_id;
		this.e_id = e_id;
		this.e_date = e_date;
		this.l_approval = l_approval;
	}
	
	
	

}
