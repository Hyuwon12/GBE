package com.kh.springProject.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springProject.board.model.dao.BoardDao;
import com.kh.springProject.board.model.vo.Board;
import com.kh.springProject.board.model.vo.Reply;
import com.kh.springProject.common.model.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Override
	
	public int listCount() {
		int listCount = boardDao.listCount(sqlSession);
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		ArrayList<Board> list = boardDao.selectList(sqlSession,pi);
		return list;
	}
	@Override
	public int increaseCount(int boardNo) {
		return boardDao.increaseCount(sqlSession,boardNo);
	}
	
	@Override
	public int insertBoard(Board b) {		
		return boardDao.insertBoard(sqlSession,b);
	}

	@Override
	public Board selectBoard(int boardNo) {		
		return boardDao.selectBoard(sqlSession,boardNo);
	}

	@Override
	public int updateBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReply(Reply r) {
		return boardDao.insertReply(sqlSession,r);
	}

	@Override
	public ArrayList<Reply> replyList(int boardNo) {		
		return boardDao.replyList(sqlSession,boardNo);
	}

	@Override
	public int selectRcount(int boardNo) {		
		return boardDao.selectRcount(sqlSession,boardNo);
	}
	
}
