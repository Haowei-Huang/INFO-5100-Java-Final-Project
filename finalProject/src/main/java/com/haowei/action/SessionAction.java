package com.haowei.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.haowei.dao.SessionDao;
import com.haowei.pojo.Session;

public class SessionAction {
	//@Test
	public void findAll() {
		SessionDao dao = new SessionDao();
		List<Session> list = new ArrayList<Session>();
		try {
			list = dao.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Session c : list) {
			System.out.println(c);
		}
	}

	// @Test
	public void findById() throws ClassNotFoundException, SQLException {
		SessionDao dao = new SessionDao();
		Session c = new Session();
		c = dao.findById(2);
		System.out.println(c);
	}

	@Test
	public void insert() throws ClassNotFoundException, SQLException {
		SessionDao dao = new SessionDao();
		Session s = new Session();
		int i;
		s.setCounsellorID(3);
		s.setCustomerID(2);
		s.setRoomID(5);
		s.setTime("2021-09-18 13:30:00");
		i = dao.insert(s);
		System.out.println(i);
	}

	//@Test
	public void delete() throws ClassNotFoundException, SQLException {
		SessionDao dao = new SessionDao();
		int i;
		i = dao.delete(6);
		System.out.println(i);
	}

	//@Test
	public void update() {
		SessionDao dao = new SessionDao();
		Session s = new Session();
		int i = -1;
		s.setSessionID(7);
		s.setCounsellorID(3);
		s.setCustomerID(2);
		s.setRoomID(5);
		s.setTime("2022-06-08 15:00:00");
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
