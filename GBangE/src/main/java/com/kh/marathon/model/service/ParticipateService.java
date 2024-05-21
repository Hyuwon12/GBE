package com.kh.marathon.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import com.kh.common.JDBCTemplate;
import com.kh.marathon.model.dao.ParticipateDao;
import com.kh.marathon.model.vo.Participate;

public class ParticipateService {

	public int insertParticipate(Participate p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ParticipateDao().insertParticipate(conn,p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ArrayList<Participate> listParticipate(int marathonNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Participate> participateList = new ParticipateDao().listParticipate(conn,marathonNo);
		JDBCTemplate.close(conn);
		return participateList;
	}
	
}
