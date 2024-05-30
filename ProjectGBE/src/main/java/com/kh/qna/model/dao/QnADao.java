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
	
	public int insertQuestion(Connection conn, Question q) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQuestion");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, q.getMemberNo());
			pstmt.setString(2, q.getQuestionTitle());
			pstmt.setString(3, q.getQuestionContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
	public int deleteAnswer(Connection conn, int answerId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAnswer");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, answerId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int selectRefQno(Connection conn, int answerId) {
		int refQno =0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRefQno");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, answerId);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				refQno=rset.getInt("REF_QNO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}	
		return refQno;
	}

}
