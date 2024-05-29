package com.kh.marathon.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RegionDao {

	public String selectRegion(SqlSessionTemplate sqlSession, int regionId) {		
		return sqlSession.selectOne("regionMapper.selectRegion", regionId);
	}
	public int selectRegionId(SqlSessionTemplate sqlSession, String regionName) {
		return sqlSession.selectOne("regionMapper.selectRegionId", regionName);
	}
}
