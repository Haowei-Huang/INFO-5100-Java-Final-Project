package com.haowei.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.haowei.pojo.Counsellor;

public abstract class Dao {
	public List findAll() throws ClassNotFoundException, SQLException {
		return null;
	}
	public Object findById(int i) throws ClassNotFoundException, SQLException{
		return null;
	}
	public int insert(Object t)throws ClassNotFoundException, SQLException{
		return 0;
	}
	public int delete(int i) throws ClassNotFoundException, SQLException{
		return 0;
	}
	public int update(Object t) throws ClassNotFoundException, SQLException{
		return 0;
	}
}
