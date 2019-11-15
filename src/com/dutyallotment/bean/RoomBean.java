package com.dutyallotment.bean;

import java.io.Serializable;

public class RoomBean implements Serializable {
	
	private int r_id;
	private String r_department;
	private int r_strength;

	public RoomBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RoomBean(int r_id, String r_department, int r_strength) {
		super();
		this.r_id = r_id;
		this.r_department = r_department;
		this.r_strength = r_strength;
	}



	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_department() {
		return r_department;
	}

	public void setR_department(String r_department) {
		this.r_department = r_department;
	}

	public int getR_strength() {
		return r_strength;
	}

	public void setR_strength(int r_strength) {
		this.r_strength = r_strength;
	}
	
	

}
