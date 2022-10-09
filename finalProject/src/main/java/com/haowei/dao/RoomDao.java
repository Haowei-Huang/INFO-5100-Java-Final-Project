package com.haowei.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.haowei.mapper.RoomMapper;
import com.haowei.pojo.Room;

public class RoomDao extends Dao{
	public List findAll() throws ClassNotFoundException, SQLException {
		Utils db = new Utils();

		List<Room> list = new ArrayList<Room>();
		String sql = "select * from Room";
		RoomMapper mapper = new RoomMapper();
		Object[] params = {};
		list = db.query3(sql, mapper, params);
		return list;
	}

	public Room findById(int id) throws ClassNotFoundException, SQLException {
		Utils db = new Utils();
		List<Room> list = new ArrayList<Room>();
		String sql = "select * from Room where RoomID = ?";
		RoomMapper mapper = new RoomMapper();
		Object[] params = { id };
		list = db.query3(sql, mapper, params);
		return list.get(0);
	}

	// insert
	public int insert(Room s) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "insert into Room(roomID, maxCapacity) "
				+ "values(null, ?);";
		Object[] params = {s.getMaxCapacity()};
		i = db.cud2(sql, params);
		return i;
	}

	// delete
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "delete from Room where roomID =?;";
		Object[] params = { id };
		i = db.cud2(sql, params);
		return i;
	}

	// update
	public int update(Room s) throws ClassNotFoundException, SQLException {
		int i;
		Utils db = new Utils();
		String sql = "update Room set maxCapacity=? where RoomID=?;";
		Object[] params = {s.getMaxCapacity(), s.getRoomID() };
		i = db.cud2(sql, params);
		return i;
	}
}
