package com.haowei.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.haowei.dao.RoomDao;
import com.haowei.pojo.Room;

public class RoomAction {
	//@Test
	public void findAll() {
		RoomDao dao = new RoomDao();
		List<Room> list = new ArrayList<Room>();
		try {
			list = dao.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Room c : list) {
			System.out.println(c);
		}
	}

	//@Test
	public void findById() throws ClassNotFoundException, SQLException {
		RoomDao dao = new RoomDao();
		Room c = new Room();
		c = dao.findById(2);
		System.out.println(c);
	}

	//@Test
	public void insert() throws ClassNotFoundException, SQLException {
		RoomDao dao = new RoomDao();
		Room s = new Room();
		int i;
		s.setMaxCapacity(12);
		i = dao.insert(s);
		System.out.println(i);
	}

	//@Test
	public void delete() throws ClassNotFoundException, SQLException {
		RoomDao dao = new RoomDao();
		int i;
		i = dao.delete(7);
		System.out.println(i);
	}

	//@Test
	public void update() {
		RoomDao dao = new RoomDao();
		Room s = new Room();
		int i = -1;
		s.setRoomID(8);
		s.setMaxCapacity(1);
		System.out.println(s);
		try {
			i = dao.update(s);
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
