package com.haowei.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.haowei.dao.SpecialityDao;
import com.haowei.pojo.Speciality;

public class SpecialityAction {
	
	//@Test
	public void findAll() {
		SpecialityDao dao = new SpecialityDao();
		List<Speciality> list = new ArrayList<Speciality>();
		try {
			list = dao.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Speciality c : list) {
			System.out.println(c);
		}
	}

	// @Test
	public void findById() throws ClassNotFoundException, SQLException {
		SpecialityDao dao = new SpecialityDao();
		Speciality c = new Speciality();
		c = dao.findById(2);
		System.out.println(c);
	}

	//@Test
	public void insert() throws ClassNotFoundException, SQLException {
		SpecialityDao dao = new SpecialityDao();
		Speciality s = new Speciality();
		int i;
		s.setDescription("test");
		i = dao.insert(s);
		System.out.println(i);
	}

	//@Test
	public void delete() throws ClassNotFoundException, SQLException {
		SpecialityDao dao = new SpecialityDao();
		int i;
		i = dao.delete(6);
		System.out.println(i);
	}

	//@Test
	public void update() {
		SpecialityDao dao = new SpecialityDao();
		Speciality s = new Speciality();
		int i = -1;
		s.setSpecialityID(7);
		s.setDescription("Test");
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
