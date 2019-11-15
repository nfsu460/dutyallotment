package com.dutyallotment.bean;

import java.io.Serializable;

public class FinalDutyAllotmentBean implements Serializable {
	
	private String e_date;
	private String e_shift;
	private int r_id;
	private String faculty_name1;
	private String faculty_name2;
	private String e_subject;
	
	

	public FinalDutyAllotmentBean() {
		// TODO Auto-generated constructor stub
	}



	public FinalDutyAllotmentBean(String e_date, String e_shift, int r_id, String faculty_name1, String faculty_name2,
			String e_subject) {
		super();
		this.e_date = e_date;
		this.e_shift = e_shift;
		this.r_id = r_id;
		this.faculty_name1 = faculty_name1;
		this.faculty_name2 = faculty_name2;
		this.e_subject = e_subject;
	}



	public String getE_date() {
		return e_date;
	}



	public void setE_date(String e_date) {
		this.e_date = e_date;
	}



	public String getE_shift() {
		return e_shift;
	}



	public void setE_shift(String e_shift) {
		this.e_shift = e_shift;
	}



	public int getR_id() {
		return r_id;
	}



	public void setR_id(int r_id) {
		this.r_id = r_id;
	}



	public String getFaculty_name1() {
		return faculty_name1;
	}



	public void setFaculty_name1(String faculty_name1) {
		this.faculty_name1 = faculty_name1;
	}



	public String getFaculty_name2() {
		return faculty_name2;
	}



	public void setFaculty_name2(String faculty_name2) {
		this.faculty_name2 = faculty_name2;
	}



	public String getE_subject() {
		return e_subject;
	}



	public void setE_subject(String e_subject) {
		this.e_subject = e_subject;
	}
	
	
	

}
