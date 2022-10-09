package com.haowei.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.mapper.SessionMapper;
import com.haowei.pojo.Session;

public class SessionDao extends Dao{
	public List findAll() throws ClassNotFoundException, SQLException {
		Utils db = new Utils();

		List<Session> list = new ArrayList<Session>();
		String sql = "select * from Session";
		SessionMapper mapper = new SessionMapper();
		Object[] params = {};
		list = db.query3(sql, mapper, params);
		return list;
	}

	public Session findById(int id) throws ClassNotFoundException, SQLException {
		Utils db = new Utils();
		List<Session> list = new ArrayList<Session>();
		String sql = "select * from Session where sessionID = ?";
		SessionMapper mapper = new SessionMapper();
		Object[] params = { id };
		list = db.query3(sql, mapper, params);
		return list.get(0);
	}

	// insert
	public int insert(Session s) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "insert into Session(sessionID, time, FK_Customer, FK_Counsellor, FK_Room) "
				+ "values(null, ?, ?, ?, ?);";
		Object[] params = {s.getTime(), s.getCustomerID(), s.getCounsellorID(), s.getRoomID()};
		i = db.cud2(sql, params);
		return i;
	}

	// delete
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "delete from Session where SessionID =?;";
		Object[] params = { id };
		i = db.cud2(sql, params);
		return i;
	}

	// update
	public int update(Session s) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "update Session set time=?, FK_Customer=?, FK_Counsellor=?, FK_Room=?"
				+ " where SessionID=?;";
		Object[] params = {s.getTime(), s.getCustomerID(), s.getCounsellorID(), 
				s.getRoomID(), s.getSessionID() };
		i = db.cud2(sql, params);
		return i;
	}
}
