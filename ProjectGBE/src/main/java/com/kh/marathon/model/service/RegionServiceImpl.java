package com.kh.marathon.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.marathon.model.dao.RegionDao;
@Service
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionDao regionDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public String selectRegion(int regionId) {
		return regionDao.selectRegion(sqlSession,regionId);
	}
	@Override
	public int selectRegionId(String regionName) {
		return regionDao.selectRegionId(sqlSession,regionName);
	}
	
}
