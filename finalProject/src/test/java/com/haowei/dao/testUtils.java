package com.haowei.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.haowei.mapper.CounsellorMapper;
import com.haowei.mapper.CustomerMapper;
import com.haowei.mapper.RoomMapper;
import com.haowei.mapper.SessionMapper;
import com.haowei.mapper.SpecialityMapper;
import com.haowei.pojo.Counsellor;
import com.haowei.pojo.Customer;
import com.haowei.pojo.Room;
import com.haowei.pojo.Session;
import com.haowei.pojo.Speciality;

public class testUtils {

//	@Test
//	public void test() {

//		try {
//			System.out.println(Utils.getConn().isClosed());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void query1() {
//		String sql = "select * from counsellor";
//		Utils db = new Utils();
//		try {
//			ResultSet rs = db.query1(sql);
//			while(rs.next()) {
//				System.out.println(rs.getString("fname"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	//@Test
	public void query2() {
		String sql = "select * from Session";
		Utils db = new Utils();
		try {
			List<Session> list = db.query2(sql, new SessionMapper());
			for (Session i : list) {
				System.out.println(i.toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void query3() {
		String sql = "select * from Speciality where SpecialityID = ?";
		Utils db = new Utils();
		Object[] params = {3};
		try {
			List<Speciality> list = db.query3(sql, new SpecialityMapper(),params);
			for (Speciality i : list) {
				System.out.println(i.toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
//	public void cud() {
//		String sql = "update counsellor set phone=\"1362598633\" where counsellorID = 1";
//		Utils db = new Utils();
//		try {
//			int i = db.cud(sql);
//			System.out.println(i);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
