package com.haowei.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.pojo.Speciality;

public class SpecialityMapper implements Mapper{

	public List mapper(ResultSet rs) {
		List<Speciality> list = new ArrayList<Speciality>();
		try {
			while (rs.next()) {
				Speciality sp = new Speciality();
				sp.setSpecialityID(rs.getInt("specialityID"));
				sp.setDescription(rs.getString("description"));
				list.add(sp);
			}
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
		return list;
	}

}
