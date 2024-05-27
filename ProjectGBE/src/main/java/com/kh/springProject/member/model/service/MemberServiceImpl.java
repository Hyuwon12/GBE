package com.kh.springProject.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springProject.member.model.dao.MemberDao;
import com.kh.springProject.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
		
	@Autowired
	private SqlSessionTemplate sqlSession;
		
	@Override
	public Member loginMember(Member m) {

		Member loginUser = memberDao.loginMember(sqlSession,m);
		return loginUser;
	}
	
	@Override
	public int insertMember(Member m) {
		//insert 트랜잭션 처리가 필요하지만
		//스프링에서 관리하기때문에 직접 처리하지 않는다.
		//sqlSessionTemplate이 처리함
		return memberDao.insertMember(sqlSession,m);

	}
	@Override
	public int updateMember(Member m) {
		return memberDao.updateMember(sqlSession,m);
	}

	@Override
	public int deleteMember(Member m) {
		return memberDao.deleteMember(sqlSession,m);
	}
	
}
