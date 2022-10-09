package com.haowei.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.haowei.mapper.Mapper;

// Provide basic JDBC methods
public class Utils {
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASS;
	
	static {
		Properties p = new Properties();
		// Read the properties file from the same directory
		InputStream in = Utils.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			//load the properties
			p.load(in);
			DRIVER = p.getProperty("DRIVER");
			URL = p.getProperty("URL");
			USER = p.getProperty("USER");
			PASS = p.getProperty("PASS");
		} catch (IOException e) {
			System.out.println("IOException" + e.getMessage());
		}
	}

	public Connection getConn() throws SQLException, ClassNotFoundException {
		// Step 1. Load the JDBC Driver, Register the driver with the driver manager
		Class.forName(DRIVER);

		// Step 2. Establish a connection
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}
	
	// Execute a query without input parameters, return ResultSet
	public ResultSet query1(String sql) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		Utils util = new Utils();
		conn = util.getConn();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		return rs;
	}
	
	// Execute a query with pojo mapper, return a List of Pojo
	public List query2(String sql, Mapper mapr) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		List list = null;
		
		Utils util = new Utils();
		conn = util.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// be sure to use executeQuery() with no parameter
		
		list = mapr.mapper(rs);
		return list;
	}
	
	// Execute a query with parameters and pojo mapper; return a List of Pojo
	public List query3(String sql, Mapper mapr, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		List list = null;
		Utils util = new Utils();
		conn = util.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			// Notice that the index of the first parameter of setObject() starts from 1
			pstmt.setObject(i + 1, params[i]);
		}

		ResultSet rs = pstmt.executeQuery();
		list = mapr.mapper(rs);

		return list;
	}

	// Create, update or delete records
	public int cud(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Utils util = new Utils();
		conn = util.getConn();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int i = -1; // i stands for i rows affected
		i = pstmt.executeUpdate();
		return i;
	}
	
	// Create, update or delete records using parameters
	public int cud2(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Utils util = new Utils();
		conn = util.getConn();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		for (int j = 0; j < params.length; j++) {
			pstmt.setObject(j+1, params[j]);
		}

		int i = -1;
		i = pstmt.executeUpdate();
		return i;
	}
}
