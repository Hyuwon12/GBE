package com.kh.marathon.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.marathon.model.vo.Participate;

public class ParticipateDao {

	public int insertParticipate(SqlSessionTemplate sqlSession, Participate p) {		
		return sqlSession.insert("participateMapper.insertParticipate", p);
	}

	public ArrayList<Participate> listParticipate(SqlSessionTemplate sqlSession, int marathonNo) {		
		List<Participate> plist = sqlSession.selectList("participateMapper.listParticipate", marathonNo);
		return (ArrayList<Participate>)plist;
	}
}
