package com.haowei.pojo;

public class Speciality {
	private int specialityID;
	private String description;

	public int getSpecialityID() {
		return specialityID;
	}

	public void setSpecialityID(int specialityID) {
		this.specialityID = specialityID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Speciality [specialityID=" + specialityID + ", description=" + description + "]";
	}

}
