package com.kh.marathon.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.common.JDBCTemplate;
import com.kh.marathon.model.vo.Marathon;
@Repository
public class MarathonDao{

	public int insertMarathon(SqlSessionTemplate sqlSession, Marathon m) {        
        return sqlSession.insert("marathonMapper.insertMarathon", m);
    }
	
	public int deleteAllMarathon(SqlSessionTemplate sqlSession) {		
		return sqlSession.delete("marathonMapper.deleteAllMarathon");
	}
	
	public ArrayList<Marathon> selectMarathon(SqlSessionTemplate sqlSession) {		
		List<Marathon> marathonArr = sqlSession.selectList("marathonMapper.selectMarathon");
		return (ArrayList<Marathon>)marathonArr;
	}
	
	public int deleteMarathon(SqlSessionTemplate sqlSession, int marathonNo) {
		return sqlSession.delete("marathonMapper.deleteMarathon", marathonNo);
	}
	
	public Marathon marathonDetail(SqlSessionTemplate sqlSession, int marathonNo) {		
		return sqlSession.selectOne("marathonMapper.marathonDetail", marathonNo);
	}
	
	public ArrayList<Marathon> selectDeleteMarathon(SqlSessionTemplate sqlSession) {
		List<Marathon> marathonArr = sqlSession.selectList("marathonMapper.selectMarathon");
		return (ArrayList<Marathon>)marathonArr;
	}
	
	public int restoreMarathon(SqlSessionTemplate sqlSession, int marathonNo) {	
		return sqlSession.update("marathonMapper.restoreMarathon", marathonNo);
	}
	
	public int updateMarathon(SqlSessionTemplate sqlSession, Marathon m) {
		return sqlSession.update("marathonMapper.updateMarathon", m);
	}

	

	public String selectMarathonRegionName(Connection conn, int marathonNo) {
		String regionName = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMarathonRegionName");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, marathonNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				regionName=rset.getString("REGION");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return regionName;
	}
	public JSONArray selectSearch(Connection conn, String searchName) {
		JSONArray searchArr = new JSONArray();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSearch");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setString(2, "%"+searchName+"%");
			pstmt.setString(3, "%"+searchName+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("marathonNo",rset.getString("MARATHON_NO"));
				jobj.put("marathonName",rset.getString("MARATHON_NAME"));
				jobj.put("location",rset.getString("LOCATION"));
				jobj.put("region",rset.getString("REGION"));
				jobj.put("marathonDate",rset.getString("MARATHON_DATE").substring(0, rset.getString("MARATHON_DATE").indexOf(" ")));
				jobj.put("marathonSite",rset.getString("MARATHON_SITE"));
				jobj.put("organizer", rset.getString("ORGANIZER"));
				String otherIntroduction = rset.getString("OTHER_INTRODUCTION");
				if(otherIntroduction!=null&&otherIntroduction.length()>50) {
					otherIntroduction = otherIntroduction.substring(0,50);
				}
				jobj.put("otherIntroduction", otherIntroduction);
				jobj.put("imageNo", rset.getInt("IMAGE_NO"));
				searchArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return searchArr;
	}

}