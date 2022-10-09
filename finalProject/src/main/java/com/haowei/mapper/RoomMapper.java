package com.haowei.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.pojo.Room;

public class RoomMapper implements Mapper {

	public List mapper(ResultSet rs) {
		List<Room> list = new ArrayList<Room>();
		try {
			while (rs.next()) {
				Room rm = new Room();
				rm.setRoomID(rs.getInt("roomID"));
				rm.setMaxCapacity(rs.getInt("maxCapacity"));
				list.add(rm);
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return list;
	}

}
