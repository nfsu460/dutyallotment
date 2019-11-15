package com.dutyallotment.bean;

import java.io.Serializable;

public class FacultyBean implements Serializable {
	
	private int faculty_id;
	private String faculty_name;
	private String faculty_email;
	private String faculty_mobile;
	private String faculty_password;
	private int faculty_availability;
	private int faculty_approval;
	
	public FacultyBean(int faculty_id, String faculty_name, String faculty_email, String faculty_mobile,
			String faculty_password, int faculty_availability, int faculty_approval) {
		super();
		this.faculty_id = faculty_id;
		this.faculty_name = faculty_name;
		this.faculty_email = faculty_email;
		this.faculty_mobile = faculty_mobile;
		this.faculty_password = faculty_password;
		this.faculty_availability = faculty_availability;
		this.faculty_approval = faculty_approval;
	}
	
	public FacultyBean() {
		
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

	public String getFaculty_email() {
		return faculty_email;
	}

	public void setFaculty_email(String faculty_email) {
		this.faculty_email = faculty_email;
	}

	public String getFaculty_mobile() {
		return faculty_mobile;
	}

	public void setFaculty_mobile(String faculty_mobile) {
		this.faculty_mobile = faculty_mobile;
	}

	public String getFaculty_password() {
		return faculty_password;
	}

	public void setFaculty_password(String faculty_password) {
		this.faculty_password = faculty_password;
	}

	public int getFaculty_availability() {
		return faculty_availability;
	}

	public void setFaculty_availability(int faculty_availability) {
		this.faculty_availability = faculty_availability;
	}

	public int getFaculty_approval() {
		return faculty_approval;
	}

	public void setFaculty_approval(int faculty_approval) {
		this.faculty_approval = faculty_approval;
	}
	
	
	
}
