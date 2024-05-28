package com.kh.marathon.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.marathon.model.dao.ParticipateDao;
import com.kh.marathon.model.vo.Participate;

@Service
public class ParticipateServiceImpl implements ParticipateService{
	@Autowired
	private ParticipateDao participateDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertParticipate(Participate p) {
		return participateDao.insertParticipate(sqlSession, p);
	}
	@Override
	public ArrayList<Participate> listParticipate(int marathonNo) {
		return participateDao.listParticipate(sqlSession,marathonNo);
	}
	
}
