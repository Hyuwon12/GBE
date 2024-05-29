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

	public String selectMarathonRegionName(SqlSessionTemplate sqlSession, int marathonNo) {
		return sqlSession.selectOne("marathonMapper.selectMarathonRegion", marathonNo);
	}
	
	public ArrayList<Marathon> searchMarathon(SqlSessionTemplate sqlSession, String searchName) {
		searchName = "%"+searchName+"%";
		List<Marathon> searchList = sqlSession.selectList("marathonMapper.searchMarathon", searchName);
		return (ArrayList<Marathon>)searchList;
	}

}