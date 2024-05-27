package com.kh.springProject.board.model.service;

import java.util.ArrayList;

import com.kh.springProject.board.model.vo.Board;
import com.kh.springProject.board.model.vo.Reply;
import com.kh.springProject.common.model.vo.PageInfo;

public interface BoardService {
	//게시글목록과 페이징처리
	int listCount();
	ArrayList<Board> selectList(PageInfo pi);
	int insertBoard(Board b);
	Board selectBoard(int boardNo);
	int increaseCount(int boardNo);
	int updateBoard(int boardNo);
	int deleteBoard(int boardNo);
	int insertReply(Reply r);
	ArrayList<Reply> replyList(int boardNo);
	int selectRcount (int boardNo);
}
