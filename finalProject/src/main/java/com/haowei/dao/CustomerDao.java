package com.haowei.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.mapper.CustomerMapper;
import com.haowei.pojo.Customer;

public class CustomerDao {
	public List findAll() throws ClassNotFoundException, SQLException {
		Utils db = new Utils();

		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from customer";
		CustomerMapper mapper = new CustomerMapper();
		Object[] params = {};
		list = db.query3(sql, mapper, params);
		return list;
	}

	public Customer findById(int id) throws ClassNotFoundException, SQLException {
		Utils db = new Utils();
		List<Customer> list = new ArrayList<Customer>();
		String sql = "select * from Customer where CustomerID = ?";
		CustomerMapper mapper = new CustomerMapper();
		Object[] params = { id };
		list = db.query3(sql, mapper, params);
		return list.get(0);
	}

	// insert
	public int insert(Customer c) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "insert into Customer(CustomerID, fname, lname, email, phone, birthday, gender) "
				+ "values(null, ?, ?, ?, ?, ?, ?);";
		Object[] params = { c.getFname(), c.getLname(), c.getEmail(), c.getPhone(), c.getDob(), c.getGender() };
		i = db.cud2(sql, params);
		return i;
	}

	// delete
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "delete from Customer where CustomerID =?;";
		Object[] params = { id };
		i = db.cud2(sql, params);
		return i;
	}

	// update
	public int update(Customer c) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "update Customer set fname=?, lname=?, email=?, phone=?, birthday=?, "
				+ "gender=? where CustomerID=?;";
		Object[] params = { c.getFname(), c.getLname(), c.getEmail(), c.getPhone(), c.getDob(), c.getGender(),
				c.getCustomerID() };
		i = db.cud2(sql, params);
		return i;
	}
}
