package com.haowei.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.mapper.CounsellorMapper;
import com.haowei.pojo.Counsellor;

public class CounsellorDao extends Dao{
	public List findAll() throws ClassNotFoundException, SQLException {
		Utils db = new Utils();

		List<Counsellor> list = new ArrayList<Counsellor>();
		String sql = "select * from Counsellor";
		CounsellorMapper mapper = new CounsellorMapper();
		Object[] params = {};
		list = db.query3(sql, mapper, params);
		return list;
	}

	public Counsellor findById(int id) throws ClassNotFoundException, SQLException {
		Utils db = new Utils();
		List<Counsellor> list = new ArrayList<Counsellor>();
		String sql = "select * from Counsellor where counsellorID = ?";
		CounsellorMapper mapper = new CounsellorMapper();
		Object[] params = { id };
		list = db.query3(sql, mapper, params);
		return list.get(0);
	}
	
	// insert
	public int insert(Counsellor c) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "insert into counsellor(counsellorID, fname, lname, email, phone, birthday, pricePerSession,"
				+ "yearStarted, introduction) values(null, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] params = { c.getFname(), c.getLname(), c.getEmail(), c.getPhone(), c.getDob(), c.getPricePerSession(),
				c.getYearStarted(), c.getIntroduction() };
		i = db.cud2(sql, params);
		return i;
	}

	// delete
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "delete from counsellor where counsellorID =?;";
		Object[] params = { id };
		i = db.cud2(sql, params);
		return i;
	}

	// update
	public int update(Counsellor c) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "update counsellor set fname=?, lname=?, "
				+ "email=?, phone=?, birthday=?, "
				+ "pricePerSession=?, yearStarted=?, introduction=? where counsellorID=?;";
		Object[] params = {c.getFname(), c.getLname(), c.getEmail(), c.getPhone(), c.getDob(), c.getPricePerSession(),
				c.getYearStarted(), c.getIntroduction(), c.getCounsellorID()};
		i = db.cud2(sql, params);
		return i;
	}
}
