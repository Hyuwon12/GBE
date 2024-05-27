package com.kh.springProject.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springProject.board.model.vo.Board;
import com.kh.springProject.board.model.vo.Reply;
import com.kh.springProject.common.model.vo.PageInfo;
@Repository
public class BoardDao {

	public int listCount(SqlSessionTemplate sqlSession) {		
		return sqlSession.selectOne("boardMapper.listCount");
	}

	public ArrayList<Board> selectList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		RowBounds rowbounds = new RowBounds(offset, limit);
		List<Board> list = sqlSession.selectList("boardMapper.selectList",null, rowbounds);
		return (ArrayList<Board>)list;
	}

	public int increaseCount(SqlSessionTemplate sqlSession, int boardNo) {		
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}

	public Board selectBoard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard",boardNo);
	}
	public int insertBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoard",b);
	}

	public ArrayList<Reply> replyList(SqlSessionTemplate sqlSession, int boardNo) {
		List<Reply> list = sqlSession.selectList("replyMapper.replyList", boardNo);
		return (ArrayList<Reply>)list; 
	}

	public int selectRcount(SqlSessionTemplate sqlSession, int boardNo) {		
		return sqlSession.selectOne("replyMapper.selectRcount", boardNo);
	}

	public int insertReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.insert("replyMapper.insertReply", r);
	}


	
}
