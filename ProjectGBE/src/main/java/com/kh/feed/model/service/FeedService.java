package com.kh.feed.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.feed.model.dao.FeedDao;
import com.kh.feed.model.vo.Attachment;
import com.kh.feed.model.vo.Category;
import com.kh.feed.model.vo.Feed;
import com.kh.feed.model.vo.Reply;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;



public class FeedService {

	public ArrayList<Feed> selectFeedList(PageInfo pi) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Feed> list = new FeedDao().selectFeedList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
		
		
	}

	public int insertFeed(Feed f, Attachment at) {
		Connection conn = JDBCTemplate.getConnection();
		
		int feedNo = new FeedDao().selectFeedNo(conn);
		
			f.setFeedNo(feedNo);
			
			int result = new FeedDao().insertFeed(conn,f);
			int result2 = new FeedDao().insertAttachment(conn, at,feedNo);

			if(result*result2>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);
			
			return result*result2;
		}
		
	

	public int listCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new FeedDao().listCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Category> cList = new FeedDao().selectCategoryList(conn);
		
		JDBCTemplate.close(conn);
		
		return cList;
	}

	public int increaseCount(int fno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().increaseCount(conn,fno);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Feed selectFeed(int fno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Feed f = new FeedDao().selectFeed(conn,fno);
		
		JDBCTemplate.close(conn);
		
		return f;
	}

	public Attachment selectAttachment(int fno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Attachment at = new FeedDao().selectAttachment(conn,fno);
		
		JDBCTemplate.close(conn);
		
		return at;
	}

	public int insertReply(Reply r) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().insertReply(conn,r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Reply> replyList(int refBno) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Reply> list = new FeedDao().replyList(conn, refBno);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public int updateFeed(Feed f, Attachment at) {
		Connection conn = JDBCTemplate.getConnection();
		
		int feedNo = new FeedDao().selectFeedNo(conn);
		
		int result = new FeedDao().updateFeed(conn,f);
		
		int result2 = 1;
		
		
		
		if(at!=null) {
			if(at.getFileNo()!=0) {
				result2 = new FeedDao().updateAttachment(conn,at);
			}else {
				result2 = new FeedDao().insertAttachment(conn, at,feedNo);
			}
		}
		
		if(result*result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result*result2;
	}

	public int deleteFeed(int feedNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().deleteFeed(conn,feedNo);
		
		if(result>0) {
			
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteReply(Reply r) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().deleteReply(conn,r);
		
		if(result>0) {
			
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int addLike(int feedNo, int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().addLike(conn,feedNo,memberNo);
		System.out.println(result);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
		


	public int removeLike(int feedNo, int memberNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().removeLike(conn,feedNo,memberNo);
	
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int selectLike(int feedNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new FeedDao().selectLike(conn,feedNo);
	
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}
	//검색 기능
	public ArrayList<Feed> searchFeedList(String searchType, String keyword){
		 Connection conn = JDBCTemplate.getConnection();
		 ArrayList<Feed> list = new ArrayList<>();
		
		 try {
		        FeedDao feedDAO = new FeedDao(); 
		        switch (searchType) {
		            case "titleContent":
		                list = feedDAO.searchTitleContent(conn, searchType, keyword);
		                break;
		            case "content":
		                list = feedDAO.searchContent(conn, searchType, keyword);
		                break;
		            case "title":
		                list = feedDAO.searchTitle(conn, searchType, keyword);
		                break;
		            default:
		                break;
		        }
		   
		    } catch (Exception e) {
		        e.printStackTrace(); 
		    } finally {
		        JDBCTemplate.close(conn); 
		    }

		    return list;
		}
}
	




