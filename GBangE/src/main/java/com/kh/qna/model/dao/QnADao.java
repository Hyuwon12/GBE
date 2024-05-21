package com.kh.qna.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.common.JDBCTemplate;
import com.kh.qna.model.vo.Answer;
import com.kh.qna.model.vo.Question;

public class QnADao {
	Properties prop = new Properties();
	public QnADao() {
		String filePath = QnADao.class.getResource("/resources/sql/qna-mapper.xml").getPath();		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public JSONArray selectQuestion(Connection conn) {
		JSONArray questionArr = new JSONArray();
		java.sql.Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQuestion");
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("questionId",rset.getInt("QUESTION_ID"));
				jobj.put("memberName",rset.getString("MEMBER_NAME"));
				jobj.put("questionTitle",rset.getString("QUESTION_TITLE"));
				jobj.put("questionContent",rset.getString("QUESTION_CONTENT"));
				jobj.put("createDate",rset.getDate("CREATE_DATE"));
				questionArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return questionArr;
	}
	public int insertAnswer(Connection conn, Answer a) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAnswer");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, a.getMemberNo());
			pstmt.setInt(2, a.getRefQno());
			pstmt.setString(3, a.getAnswerTitle());
			pstmt.setString(4, a.getAnswerContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public JSONArray selectAnswer(Connection conn, int questionId) {
		JSONArray answerArr = new JSONArray();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAnswer");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionId);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("answerId",rset.getInt("ANSWER_ID"));
				jobj.put("memberNo",rset.getInt("MEMBER_NO"));
				jobj.put("memberName",rset.getString("MEMBER_NAME"));
				jobj.put("refQno", rset.getInt("REF_QNO"));
				jobj.put("answerTitle",rset.getString("ANSWER_TITLE"));
				jobj.put("answerContent",rset.getString("ANSWER_CONTENT"));
				jobj.put("createDate",rset.getDate("CREATE_DATE"));
				answerArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return answerArr;
	}
	public JSONArray selectAllAnswer(Connection conn) {
		JSONArray answerArr = new JSONArray();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllAnswer");
		try {
			stmt = conn.createStatement();			
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("answerId",rset.getInt("ANSWER_ID"));
				jobj.put("memberName",rset.getString("MEMBER_NAME"));
				jobj.put("refQno", rset.getInt("REF_QNO"));
				jobj.put("answerTitle",rset.getString("ANSWER_TITLE"));
				jobj.put("answerContent",rset.getString("ANSWER_CONTENT"));
				jobj.put("createDate",rset.getDate("CREATE_DATE"));
				answerArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return answerArr;
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
