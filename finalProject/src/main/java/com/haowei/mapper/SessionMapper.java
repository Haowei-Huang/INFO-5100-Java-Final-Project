package com.haowei.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.pojo.Session;

public class SessionMapper implements Mapper {

	public List mapper(ResultSet rs) {
		List<Session> list = new ArrayList<Session>();
		try {
			while (rs.next()) {
				Session se = new Session();
				se.setSessionID(rs.getInt("sessionID"));
				se.setTime(rs.getString("time"));
				se.setCounsellorID(rs.getInt("FK_Counsellor"));
				se.setCustomerID(rs.getInt("FK_Customer"));
				se.setRoomID(rs.getInt("FK_Room"));
				list.add(se);
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return list;
	}
}
