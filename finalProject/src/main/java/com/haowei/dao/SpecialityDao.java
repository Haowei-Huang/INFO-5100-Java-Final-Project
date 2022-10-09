package com.haowei.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.mapper.SpecialityMapper;
import com.haowei.pojo.Speciality;

public class SpecialityDao {
	public List findAll() throws ClassNotFoundException, SQLException {
		Utils db = new Utils();

		List<Speciality> list = new ArrayList<Speciality>();
		String sql = "select * from Speciality";
		SpecialityMapper mapper = new SpecialityMapper();
		Object[] params = {};
		list = db.query3(sql, mapper, params);
		return list;
	}

	public Speciality findById(int id) throws ClassNotFoundException, SQLException {
		Utils db = new Utils();
		List<Speciality> list = new ArrayList<Speciality>();
		String sql = "select * from Speciality where SpecialityID = ?";
		SpecialityMapper mapper = new SpecialityMapper();
		Object[] params = { id };
		list = db.query3(sql, mapper, params);
		return list.get(0);
	}

	// insert
	public int insert(Speciality s) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "insert into Speciality(SpecialityID, description) "
				+ "values(null, ?);";
		Object[] params = {s.getDescription()};
		i = db.cud2(sql, params);
		return i;
	}

	// delete
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "delete from Speciality where SpecialityID =?;";
		Object[] params = { id };
		i = db.cud2(sql, params);
		return i;
	}

	// update
	public int update(Speciality s) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "update Speciality set description=? where SpecialityID=?;";
		Object[] params = {s.getDescription(), s.getSpecialityID() };
		i = db.cud2(sql, params);
		return i;
	}
}
