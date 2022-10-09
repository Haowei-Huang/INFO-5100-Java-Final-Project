package com.haowei.pojo;

public class Room {
	private int roomID;
	private int maxCapacity;

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", maxCapacity=" + maxCapacity + "]";
	}

}
