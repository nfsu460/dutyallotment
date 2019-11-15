package com.dutyallotment.bean;

import java.io.Serializable;

public class FacultyExamLeaveBean implements Serializable {
	private int l_id;
	private int faculty_id;
	private String faculty_name;
	private int e_id;
	private String e_date;
	
	public FacultyExamLeaveBean(int l_id, int faculty_id, String faculty_name, int e_id, String e_date) {
		super();
		this.l_id = l_id;
		this.faculty_id = faculty_id;
		this.faculty_name = faculty_name;
		this.e_id = e_id;
		this.e_date = e_date;
	}

	public FacultyExamLeaveBean() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
}
