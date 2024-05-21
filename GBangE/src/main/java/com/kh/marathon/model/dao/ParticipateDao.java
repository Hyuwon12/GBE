package com.kh.marathon.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONArray;

import com.google.gson.Gson;
import com.kh.common.JDBCTemplate;
import com.kh.marathon.model.vo.Participate;

public class ParticipateDao {
private Properties prop = new Properties();
	
	public ParticipateDao() {
		String filePath = ParticipateDao.class.getResource("/resources/sql/participate-mapper.xml").getPath();		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertParticipate(Connection conn, Participate p) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("insertParticipate");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getMemberNo());
			pstmt.setInt(2, p.getMarathonNo());
			pstmt.setInt(3, p.getRegionId());
			pstmt.setString(4, p.getName());
			pstmt.setString(5, p.getParticipateCourse());
			pstmt.setString(6, p.getPassword());
			pstmt.setString(7, p.getRegisterationNo());
			pstmt.setString(8, p.getGender());
			pstmt.setString(9, p.getPhone());
			pstmt.setString(10, p.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Participate> listParticipate(Connection conn, int marathonNo) {
		ArrayList<Participate> participateList = new JSONArray();
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String sql = prop.getProperty("listParticipate");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, marathonNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Participate p = new Participate();
				p.setParticipateNo(rset.getInt("PARTICIPATE_NO"));
				p.setName(rset.getString("NAME"));
				p.setMarathonName(rset.getString("MARATHON_NAME"));
				p.setParticipateCourse(rset.getString("PARTICIPATE_COURSE"));
				p.setRegionName(rset.getString("REGION_NAME"));
				p.setParticipateDate(rset.getDate("PARTICIPATE_DATE"));
				p.setPhone(rset.getString("PHONE"));
				participateList.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return participateList;
	}
}
