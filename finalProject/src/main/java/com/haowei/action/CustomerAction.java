package com.haowei.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.haowei.dao.CustomerDao;
import com.haowei.pojo.Customer;

public class CustomerAction {
	//@Test
	public void findAll() {
		CustomerDao dao = new CustomerDao();
		List<Customer> list = new ArrayList<Customer>();
		
		try {
			list = dao.findAll();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Customer c : list) {
			System.out.println(c);
			System.out.println();
		}
	}

	//@Test
	public void findById() throws ClassNotFoundException, SQLException {
		CustomerDao dao = new CustomerDao();
		Customer c = new Customer();
		c = dao.findById(2);
		System.out.println(c);
	}

	//@Test
	public void insert() throws ClassNotFoundException, SQLException {
		CustomerDao dao = new CustomerDao();
		Customer c = new Customer();
		int i;
		c.setFname("Test");
		c.setLname("t");
		c.setEmail("t@t.com");
		c.setPhone("123");
		c.setDob("1999-09-09");
		c.setGender("M");
		i = dao.insert(c);
		System.out.println(i);
	}

	//@Test
	public void delete() throws ClassNotFoundException, SQLException {
		CustomerDao dao = new CustomerDao();
		int i;
		i = dao.delete(6);
		System.out.println(i);
	}

	@Test
	public void update() {
		CustomerDao dao = new CustomerDao();
		Customer c = new Customer();
		int i = -1;
		c.setCustomerID(7);
		c.setFname("t");
		c.setLname("Q");
		c.setEmail("Q@Q.com");
		c.setPhone("123");
		c.setDob("1999-02-09");
		c.setGender("F");
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
