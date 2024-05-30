package com.kh.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.common.JDBCTemplate;
import com.kh.qna.model.dao.QnADao;
import com.kh.qna.model.vo.Answer;
import com.kh.qna.model.vo.Question;
@Service
public class QnAServiceImpl implements QnAService {
	@Autowired
	private QnADao qnaDao;
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Question> selectQuestion() {	
		return qnaDao.selectQuestion(sqlSession);
	}

	@Override
	public ArrayList<Answer> selectAllAnswer() {
		return qnaDao.selectAllAnswer(sqlSession);
	}

	@Override
	public int insertAnswer(Answer an) {
		return qnaDao.insertAnswer(sqlSession,an);
	}
	@Override
	public ArrayList<Answer> selectAnswer(int questionId) {
		return qnaDao.selectAnswer(sqlSession,questionId);
	}
	public int insertQuestion(Question q) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new QnADao().insertQuestion(conn,q);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteAnswer(int answerId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new QnADao().deleteAnswer(conn,answerId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int selectRefQno(int answerId) {
		Connection conn = JDBCTemplate.getConnection();
		int refQno = new QnADao().selectRefQno(conn,answerId);
		JDBCTemplate.close(conn);		
		return refQno;
	}
}
