package com.haowei.pojo;

public class Session {
	private int sessionID;
	private String time;
	private int counsellorID;
	private int customerID;
	private int roomID;

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCounsellorID() {
		return counsellorID;
	}

	public void setCounsellorID(int counsellorID) {
		this.counsellorID = counsellorID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", time=" + time + ", counsellorID=" + counsellorID + ", customerID="
				+ customerID + ", roomID=" + roomID + "]";
	}

	
}
