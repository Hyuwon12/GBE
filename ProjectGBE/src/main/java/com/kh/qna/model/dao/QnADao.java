package com.kh.qna.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.kh.common.JDBCTemplate;
import com.kh.qna.model.vo.Answer;
import com.kh.qna.model.vo.Question;
@Repository
public class QnADao {
	
	public ArrayList<Question> selectQuestion(SqlSession sqlSession) {
		List<Question> questionArr = sqlSession.selectList("qnaMapper.selectQuestion");
		return (ArrayList<Question>)questionArr;
	}
	
	public ArrayList<Answer> selectAllAnswer(SqlSession sqlSession) {
		List<Answer> answerArr = sqlSession.selectList("qnaMapper.selectAllAnswer");
		return (ArrayList<Answer>)answerArr;
	}
	
	public int insertAnswer(SqlSession sqlSession, Answer an) {		
		return sqlSession.insert("qnaMapper.insertAnswer", an);
	}
	
	public ArrayList<Answer> selectAnswer(SqlSession sqlSession, int questionId) {
		List<Answer> answerArr = sqlSession.selectList("qnaMapper.selectAnswer", questionId);
		return (ArrayList<Answer>)answerArr;
	}
	
	public int insertQuestion(SqlSession sqlSession, Question q) {
		return sqlSession.insert("qnaMapper.insertQuestion",q);
	}
	public int deleteAnswer(SqlSession sqlSession, int answerId) {
		return sqlSession.delete("qnaMapper.deleteAnswer",answerId);
	}
	public int selectRefQno(SqlSession sqlSession, int answerId) {
		return sqlSession.select("qnaMapper.selectRefQno",answerId);
	}

}
