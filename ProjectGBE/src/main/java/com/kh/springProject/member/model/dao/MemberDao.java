package com.kh.springProject.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springProject.member.model.vo.Member;


@Repository
public class MemberDao {

	public Member loginMember(SqlSessionTemplate sqlSession, Member m) {
		
		Member loginMember = sqlSession.selectOne("memberMapper.loginMember",m);
		
		return loginMember;
	}

	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember",m);	
	}

	public int updateMember(SqlSessionTemplate sqlSession, Member m) {		
		return sqlSession.update("memberMapper.updateMember",m);
	}

	public int deleteMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.deleteMember",m);
	}

}
