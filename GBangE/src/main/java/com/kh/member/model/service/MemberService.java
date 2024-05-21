package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;

import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().loginMember(conn,userId,userPwd);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public int insertMember(Member m) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public boolean checkId(String inputId) {

		Connection conn = JDBCTemplate.getConnection();
		
		boolean flag = new MemberDao().checkId(conn,inputId);
		
		JDBCTemplate.close(conn);
		
		return flag;
	}

	public String findId(String userName, String userPno) {

		Connection conn = JDBCTemplate.getConnection();
		
		String userId =new MemberDao().findId(conn,userName,userPno);
		
		JDBCTemplate.close(conn);
		
		return userId;
	}

	public boolean findPwd(String userId, String userName, String userPno) {

		Connection conn = JDBCTemplate.getConnection();
		
		boolean flag = new MemberDao().findPwd(conn,userId,userName,userPno);
		
		JDBCTemplate.close(conn);
		
		return flag;
	}

	public int changePwd(String userId, String userPwd) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().changePwd(conn,userId,userPwd);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Member updateMember(Member m) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMem = null;
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getMemberId());
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return updateMem;
	}

	public int updateProfile(Member m) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateProfile(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public boolean checkPno(String pno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		boolean flag = new MemberDao().checkPno(conn, pno);
		
		JDBCTemplate.close(conn);
		
		return flag;
	}

	public int mileagePlus(int mileage, String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().mileagePlus(conn,mileage,userId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	

	

	
}
