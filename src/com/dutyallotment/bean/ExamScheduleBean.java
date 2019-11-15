package com.dutyallotment.bean;

import java.io.Serializable;

public class ExamScheduleBean implements Serializable {
	
	private int e_id;
	private String e_date;
	private String e_subject;
	private String e_slot;

	public ExamScheduleBean() {
		// TODO Auto-generated constructor stub
	}

	public ExamScheduleBean(int e_id, String e_date, String e_subject, String e_slot) {
		super();
		this.e_id = e_id;
		this.e_date = e_date;
		this.e_subject = e_subject;
		this.e_slot = e_slot;
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

	public String getE_subject() {
		return e_subject;
	}

	public void setE_subject(String e_subject) {
		this.e_subject = e_subject;
	}

	public String getE_slot() {
		return e_slot;
	}

	public void setE_slot(String e_slot) {
		this.e_slot = e_slot;
	}
	
	

}
