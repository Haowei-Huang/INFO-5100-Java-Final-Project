package com.haowei.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.pojo.Counsellor;

// This class is used to convert the ResultSet get from the database 
// to a list of pojo
public class CounsellorMapper implements Mapper{
	
	public List mapper(ResultSet rs) {
		List<Counsellor> list = new ArrayList<Counsellor>();
		try {
			while(rs.next()) {
				// create an object to store each row's data
				Counsellor cnslr = new Counsellor();
				// set the object's fields
				cnslr.setCounsellorID(rs.getInt("counsellorID"));
				cnslr.setFname(rs.getString("fname"));
				cnslr.setLname(rs.getString("lname"));
				cnslr.setEmail(rs.getString("email"));
				cnslr.setPhone(rs.getString("phone"));
				cnslr.setDob(rs.getString("birthday"));
				cnslr.setPricePerSession(rs.getInt("pricePerSession"));
				cnslr.setYearStarted(rs.getInt("yearStarted"));
				cnslr.setIntroduction(rs.getString("introduction"));
				// add the object to the list
				list.add(cnslr);
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return list;
	}

}
