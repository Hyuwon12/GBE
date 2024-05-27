package com.kh.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Attachment;
import com.kh.notice.model.vo.Notice;


public class NoticeService {
	//공지사항 글목록
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {

			Connection conn = JDBCTemplate.getConnection();
			
			ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn,pi);
			
			JDBCTemplate.close(conn);
			
			return list;
		}
	//공지사항 글작성
	public int insertNotice(Notice n, Attachment at) {
		Connection conn = JDBCTemplate.getConnection();
	    
		  int NoticeId = new NoticeDao().selectNoticeNo(conn);
		    
		    n.setNoticeId(NoticeId);
		    int result = new NoticeDao().insertNotice(conn, n);
		    int result2 = 1;
		    if (result > 0 && at != null) { // Attachment 객체가 null이 아닌 경우에만 첨부 파일을 삽입
		        result2 = new NoticeDao().insertAttachment(conn, at, NoticeId);
		        if (result * result2 > 0) {
			        JDBCTemplate.commit(conn);
			    } else {
			        JDBCTemplate.rollback(conn);
			    }
		    }
		    
		   
		    
		    JDBCTemplate.close(conn);
		    
		    return result * result2;
		}
	//조회수 증가
	public int increaseCount(int nno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().increaseCount(conn, nno);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
		
	}
	//글 상세보기
	public Notice selectNotice(int nno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn,nno);
		
		//조회구문은 트랜잭션 처리 필요없음
		
		JDBCTemplate.close(conn);
		
		
		return n;
	}
	public ArrayList<Notice> searchNoticeList(String searchType, String keyword) {
	    Connection conn = JDBCTemplate.getConnection();
	    ArrayList<Notice> list = new ArrayList<>();

	    try {
	        NoticeDao noticeDAO = new NoticeDao(); 
	        switch (searchType) {
	            case "titleContent":
	                list = noticeDAO.searchTitleContent(conn, keyword);
	                break;
	            case "content":
	                list = noticeDAO.searchContent(conn, keyword);
	                break;
	            case "title":
	                list = noticeDAO.searchTitle(conn, keyword);
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
	
	
	
	public Attachment selectAttachment(int nno) {
		Connection conn = JDBCTemplate.getConnection();
		
		Attachment at = new NoticeDao().selectAttachment(conn,nno);
		JDBCTemplate.close(conn);
		
		return at;
	}
	//게시글 수정
	public int updateNotice(Notice n, Attachment at) {
		Connection conn = JDBCTemplate.getConnection();
		
		int NoticeId = new NoticeDao().selectNoticeNo(conn); 
		
		int result = new NoticeDao().updateNotice(conn,n);
		
		int result2 = 1; 
	
		if(at!=null) {
			
			if(at.getFileNo()!=0) {  
				result2 = new NoticeDao().updateAttachment(conn,at);
			}else { 
				result2 = new NoticeDao().insertAttachment(conn, at, NoticeId);
			}
		}
		if(result*result2>0) { 
			JDBCTemplate.commit(conn);
		}else { 
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result*result2;
	}
	public int deleteNotice(int noticeId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().deleteNotice(conn,noticeId);
		//DML (UPDATE/DELETE) 구문이니 트랜잭션 처리
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
		
	}
	//이전글, 다음글로 가기 
	public int[] getPrevAndNextNoticeId(int currentNoticeId) {
	    Connection conn = JDBCTemplate.getConnection();
	    int[] prevAndNextNoticeId = new NoticeDao().getPrevAndNextNoticeId(conn, currentNoticeId);
	    JDBCTemplate.close(conn);
	    return prevAndNextNoticeId;
	}
	
	
		public int listCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int listCount = new NoticeDao().listCount(conn);
		
		JDBCTemplate.close(conn);
		
		return listCount;
	}
	
	
	

	}

	


