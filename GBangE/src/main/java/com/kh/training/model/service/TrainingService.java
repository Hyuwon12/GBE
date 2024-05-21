package com.kh.training.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import com.google.gson.annotations.Until;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.training.model.dao.TrainingDao;
import com.kh.training.model.vo.Attachment;
import com.kh.training.model.vo.Reply;
import com.kh.training.model.vo.Shoes;
import com.kh.training.model.vo.Training;
import com.kh.training.model.vo.TrainingCategory;

public class TrainingService {

	public ArrayList<TrainingCategory> selectCategoryList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<TrainingCategory> tCList = new TrainingDao().selectCategoryList(conn);

		JDBCTemplate.close(conn);
		return tCList;
	}

	public int insertTraining(Training t, Attachment at, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();

		int trainingNo = new TrainingDao().selectTrainingNo(conn);

		t.setTrainingNo(trainingNo);
		int resultTr = new TrainingDao().insertTraining(conn, t, memberNo);
		int resultAt = new TrainingDao().insertAttachment(conn, at, trainingNo);
		if (resultTr * resultAt > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return resultTr * resultAt;
	}

	public int increaseCount(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainingDao().increaseCount(conn, tno);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int listCount() {
		Connection conn = JDBCTemplate.getConnection();

		int listCount = new TrainingDao().listCount(conn);

		JDBCTemplate.close(conn);

		return listCount;
	}

	public ArrayList<Training> selectList(PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Training> list = new TrainingDao().selectList(conn, pi);

		JDBCTemplate.close(conn);

		return list;
	}

	public Training selectTraining(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		Training t = new TrainingDao().selectTraining(conn, tno);
		JDBCTemplate.close(conn);
		return t;
	}

	public Attachment selectAttachment(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		Attachment at = new TrainingDao().selectAttachment(conn, tno);
		JDBCTemplate.close(conn);
		return at;
	}

	public int updateTraining(Training t, Attachment at) {
		Connection conn = JDBCTemplate.getConnection();
		int resultTr = new TrainingDao().updateTraining(conn, t);

		int resultAt = 1;

		if (at != null) {
			if (at.getFileNo() != 0) {
				resultAt = new TrainingDao().updateAttachment(conn, at);
			} else {
				resultAt = new TrainingDao().insertAttachment(conn, at, at.getRefBno());
			}
		}

		if (resultTr * resultAt > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return resultTr * resultAt;
	}

	public int deleteTraining(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainingDao().deleteTraining(conn,tno);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertReply(Reply r) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainingDao().insertReply(conn,r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Reply> selectReplyList(int refTno) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Reply> list = new TrainingDao().selectReplyList(conn,refTno);
			JDBCTemplate.close(conn);
		return list;
	}

	public int deleteReply(Reply r) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainingDao().deleteReply(conn,r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateReply(String originReply, String changeReply, String replyWriter, int refTno) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainingDao().updateReply(conn, originReply, changeReply, refTno,replyWriter);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateLikes(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainingDao().updateLikes(conn,tno);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int selectLikes(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		int likes = new TrainingDao().selectLikes(conn, tno);
		JDBCTemplate.close(conn);
		return likes;
	}

	public ArrayList<Shoes> selectShoesList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Shoes> sList = new TrainingDao().selectShoesList(conn);
		JDBCTemplate.close(conn);
		return sList;
	}

	public Shoes selectShoes(int tno) {
		Connection conn = JDBCTemplate.getConnection();
		Shoes s = new TrainingDao().selectShoes(conn, tno);
		JDBCTemplate.close(conn);
		return s;
	}

	public ArrayList<Training> searchByTitle(PageInfo pi,String keyword) {
		Connection conn = JDBCTemplate. getConnection();
		ArrayList<Training> searchList = new TrainingDao().searchByTitle(conn,pi,keyword);
		JDBCTemplate.close(conn);
		return searchList;
	}

	public ArrayList<Training> searchByCategory(PageInfo pi,String keyword) {
		Connection conn = JDBCTemplate. getConnection();
		ArrayList<Training> searchList = new TrainingDao().searchByCategory(conn,pi,keyword);
		JDBCTemplate.close(conn);
		return searchList;
	}

	public ArrayList<Training> searchByContent(PageInfo pi,String keyword) {
		Connection conn = JDBCTemplate. getConnection();
		ArrayList<Training> searchList = new TrainingDao().searchByContent(conn,pi,keyword);
		JDBCTemplate.close(conn);
		return searchList;
	}

}
