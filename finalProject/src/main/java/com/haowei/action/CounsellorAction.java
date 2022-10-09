package com.haowei.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.haowei.dao.CounsellorDao;
import com.haowei.pojo.Counsellor;

public class CounsellorAction {
	//@Test
	public void findAll(){
		CounsellorDao dao = new CounsellorDao();
		List<Counsellor> list = new ArrayList<Counsellor>();
		try {
			list = dao.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Counsellor c : list) {
			System.out.println(c);
		}
	}
	//@Test
	public void findById() throws ClassNotFoundException, SQLException {
		CounsellorDao dao = new CounsellorDao();
		Counsellor c = new Counsellor();
		List<Counsellor> list = new ArrayList<Counsellor>();
		try {
			c = dao.findById(1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c);
	}
	//@Test
	public void insert() throws ClassNotFoundException, SQLException {
		CounsellorDao dao = new CounsellorDao();
		Counsellor c = new Counsellor();
		int i;
		c.setFname("Test");
		c.setLname("t");
		c.setEmail("t@t.com");
		c.setPhone("123");
		c.setDob("1999-09-09");
		c.setPricePerSession(99);
		c.setYearStarted(1999);
		c.setIntroduction("");
		i = dao.insert(c);
		System.out.println(i);
	}
	//@Test
	public void delete() throws ClassNotFoundException, SQLException {
		CounsellorDao dao = new CounsellorDao();
		int i;
		i = dao.delete(4);
		System.out.println(i);
	}
	//@Test
	public void update() {
		CounsellorDao dao = new CounsellorDao();
		Counsellor c = new Counsellor();
		int i = -1;
		c.setCounsellorID(5);
		c.setFname("t");
		c.setLname("Q");
		c.setEmail("Q@Q.com");
		c.setPhone("123");
		c.setDob("1999-02-09");
		c.setPricePerSession(49);
		c.setYearStarted(1989);
		c.setIntroduction("ASW");
		System.out.println(c);
		try {
			i = dao.update(c);
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
