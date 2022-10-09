package com.haowei.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.pojo.Customer;

public class CustomerMapper implements Mapper{

	public List mapper(ResultSet rs) {
		List<Customer> list = new ArrayList<Customer>();
		try {
			while(rs.next()) {
				Customer custmr = new Customer();
				custmr.setCustomerID(rs.getInt("CustomerID"));
				custmr.setFname(rs.getString("fname"));
				custmr.setLname(rs.getString("lname"));
				custmr.setEmail(rs.getString("email"));
				custmr.setPhone(rs.getString("phone"));
				custmr.setDob(rs.getString("birthday"));
				custmr.setGender(rs.getString("gender"));
				list.add(custmr);
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return list;
	}

}
