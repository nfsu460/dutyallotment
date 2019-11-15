package com.dutyallotment.bean;

import java.io.Serializable;

public class AllotmentBean implements Serializable {
	
	private int a_id;
	private int e_id;
	private int faculty_id1;
	private int faculty_id2;
	private int r_id;

	public AllotmentBean() {
		// TODO Auto-generated constructor stub
	}

	public AllotmentBean(int a_id, int e_id, int faculty_id1, int faculty_id2, int r_id) {
		super();
		this.a_id = a_id;
		this.e_id = e_id;
		this.faculty_id1 = faculty_id1;
		this.faculty_id2 = faculty_id2;
		this.r_id = r_id;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getFaculty_id1() {
		return faculty_id1;
	}

	public void setFaculty_id1(int faculty_id1) {
		this.faculty_id1 = faculty_id1;
	}

	public int getFaculty_id2() {
		return faculty_id2;
	}

	public void setFaculty_id2(int faculty_id2) {
		this.faculty_id2 = faculty_id2;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
	

}
