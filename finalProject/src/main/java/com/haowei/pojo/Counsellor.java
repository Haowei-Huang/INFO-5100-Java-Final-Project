package com.haowei.pojo;

import java.time.LocalDate;

public class Counsellor {
	private int counsellorID;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String dob;
	private int pricePerSession;
	private int yearStarted;
	private String introduction;
	
	public int getCounsellorID() {
		return counsellorID;
	}

	public void setCounsellorID(int counsellorID) {
		this.counsellorID = counsellorID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPricePerSession() {
		return pricePerSession;
	}

	public void setPricePerSession(int pricePerSession) {
		this.pricePerSession = pricePerSession;
	}

	public int getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(int yearStarted) {
		this.yearStarted = yearStarted;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "Counsellor [counsellorID=" + counsellorID + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + ", dob=" + dob + ", pricePerSession=" + pricePerSession + ", yearStarted="
				+ yearStarted + ", introduction=" + introduction + "]";
	}
	
}
