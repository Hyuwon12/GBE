package com.kh.qna.model.service;

import java.sql.Connection;

import org.json.simple.JSONArray;

import com.kh.common.JDBCTemplate;
import com.kh.qna.model.dao.QnADao;
import com.kh.qna.model.vo.Answer;
import com.kh.qna.model.vo.Question;

public class QnAService {

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

	public JSONArray selectQuestion() {
		Connection conn = JDBCTemplate.getConnection();
		JSONArray questionArr = new QnADao().selectQuestion(conn);
		JDBCTemplate.close(conn);
		return questionArr;
	}

	public int insertAnswer(Answer a) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new QnADao().insertAnswer(conn,a);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public JSONArray selectAnswer(int questionId) {
		Connection conn = JDBCTemplate.getConnection();
		JSONArray answerArr = new QnADao().selectAnswer(conn,questionId);
		JDBCTemplate.close(conn);
		return answerArr;
	}

	public JSONArray selectAllAnswer() {
		Connection conn = JDBCTemplate.getConnection();
		JSONArray answerArr = new QnADao().selectAllAnswer(conn);
		JDBCTemplate.close(conn);
		return answerArr;
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
