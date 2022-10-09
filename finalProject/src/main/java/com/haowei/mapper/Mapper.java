package com.haowei.mapper;

import java.sql.ResultSet;
import java.util.List;

// interface to map ResultSet data to an ArrayList of pojo
public interface Mapper {
	public List mapper(ResultSet rs);
	
}
