package com.kh.marathon.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.marathon.model.dao.RegionDao;

public class RegionService {

	public String selectRegion(int regionId) {
		Connection conn = JDBCTemplate.getConnection();
		String regionName = new RegionDao().selectRegion(conn,regionId);
		JDBCTemplate.close(conn);
		return regionName;
	}
	public int selectRegionId(String regionName) {
		Connection conn = JDBCTemplate.getConnection();
		int regionId = new RegionDao().selectRegionId(conn,regionName);
		JDBCTemplate.close(conn);
		return regionId;
	}
	
}
