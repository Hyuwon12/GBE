package com.kh.marathon.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;

public class RegionDao {
	private Properties prop = new Properties();
	public RegionDao() {
			String filePath = RegionDao.class.getResource("/resources/sql/region-mapper.xml").getPath();		
			try {
				prop.loadFromXML(new FileInputStream(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	public String selectRegion(Connection conn, int regionId) {
		String regionName = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRegion");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, regionId);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				regionName=rset.getString("REGION_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return regionName;
	}
	public int selectRegionId(Connection conn, String regionName) {
		int regionId = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRegionId");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, regionName);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				regionId=rset.getInt("REGION_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return regionId;
	}
}
