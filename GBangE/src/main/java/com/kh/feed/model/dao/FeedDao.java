package com.kh.feed.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.feed.model.vo.Attachment;
import com.kh.feed.model.vo.Category;
import com.kh.feed.model.vo.Feed;
import com.kh.feed.model.vo.Reply;



public class FeedDao {
	
	private Properties prop = new Properties();
	
	public FeedDao() {
		
		String filePath = FeedDao.class.getResource("/resources/sql/feed-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Feed> selectFeedList(Connection conn, PageInfo pi) {
		
		ArrayList<Feed> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectFeedList");
		
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit()+1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
		
			while(rset.next()) {
				list.add(new Feed(rset.getInt("FEED_NO")
								,rset.getString("FEED_TITLE")
								,rset.getString("MEMBER_ID")
								,rset.getInt("COUNT")
								,rset.getDate("CREATE_DATE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int insertFeed(Connection conn, Feed f) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFeed");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, f.getFeedNo());
			pstmt.setString(2, f.getCategory());
			pstmt.setString(3, f.getCompetition());
			pstmt.setString(4, f.getFeedTitle());
			pstmt.setString(5, f.getMemberNo());
			pstmt.setString(6, f.getFeedContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int listCount(Connection conn) {
		ResultSet rset = null;
		Statement stmt = null;
		String sql = prop.getProperty("listCount");
		
		int listCount = 0;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return listCount;
	}

	public ArrayList<Category> selectCategoryList(Connection conn) {
		
		ResultSet rset = null;
		ArrayList<Category> cList = new ArrayList<>();
		Statement stmt = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				cList.add(new Category(rset.getInt("CATEGORY_NO")
									  ,rset.getString("CATEGORY_NAME")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return cList;
	}

	public int selectFeedNo(Connection conn) {
		
		int feedNo = 0;
		ResultSet rset = null;
		Statement stmt = null;
		
		String sql = prop.getProperty("selectFeedNo");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				feedNo = rset.getInt("FNO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return feedNo;
	}

	public int insertAttachment(Connection conn, Attachment at, int feedNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, feedNo);
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			System.out.println(at.getRefBno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int increaseCount(Connection conn, int fno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Feed selectFeed(Connection conn, int fno) {
		
		Feed f = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectFeed");
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					f = new Feed(rset.getInt("FEED_NO")
								,rset.getString("MEMBER_ID")
								,rset.getString("CATEGORY_NAME")
								,rset.getString("MARATHON_NAME")
								,rset.getString("FEED_TITLE")
								,rset.getString("FEED_CONTENT")
								,rset.getInt("COUNT")
								,rset.getDate("CREATE_DATE")
								,rset.getInt("LIKE_COUNT"));
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
		return f;
	}

	public Attachment selectAttachment(Connection conn, int fno) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		Attachment at = null;
		String sql = prop.getProperty("selectAttachment");
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					at = new Attachment(rset.getInt("FILE_NO")
									    ,rset.getString("ORIGIN_NAME")
									    ,rset.getString("CHANGE_NAME")
									    ,rset.getString("FILE_PATH"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
		return at;
	}

	public int insertReply(Connection conn, Reply r) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBno());
			pstmt.setString(3, r.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Reply> replyList(Connection conn, int refBno) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Reply> list = new ArrayList<>();
		
		String sql = prop.getProperty("replyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, refBno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Reply(rset.getInt("REPLY_NO")
								  ,rset.getString("REPLY_CONTENT")
								  ,rset.getString("MEMBER_ID")
								  ,rset.getDate("CREATE_DATE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int updateFeed(Connection conn, Feed f) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFeed");
		
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, f.getCategory());
				pstmt.setString(2, f.getCompetition());
				pstmt.setString(3, f.getFeedTitle());
				pstmt.setString(4, f.getFeedContent());
				pstmt.setInt(5, f.getFeedNo());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileNo());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		return result;
	}

	public int deleteFeed(Connection conn, int feedNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFeed");
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, feedNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		return result;
	}

	public int deleteReply(Connection conn, Reply r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getReplyNo());
			pstmt.setString(2, r.getMemberNo());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int addLike(Connection conn, int feedNo, int memberNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("addLike");
		
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, feedNo);
	        
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCTemplate.close(pstmt);
	    }
	    return result;
	}

	public int removeLike(Connection conn, int feedNo, int memberNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("removeLike");
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, feedNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		return result;
	}

	public int selectLike(Connection conn, int feedNo) {
		
		ResultSet rset = null; 
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectLike");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, feedNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("LIKE_COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Feed> searchTitleContent(Connection conn, String searchType, String keyword) {
		ArrayList<Feed> list = new ArrayList<>();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("searchTitleContent"); 
		 
		 try {
			 	pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				pstmt.setString(2, "%" + keyword + "%");
	        
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Feed feed = new Feed();
				feed.setFeedNo(rset.getInt("FEED_NO"));
				feed.setFeedTitle(rset.getString("FEED_TITLE"));
				feed.setFeedContent(rset.getString("FEED_CONTENT"));
				feed.setMemberNo(rset.getString("MEMBER_ID"));
				feed.setCount(rset.getInt("COUNT"));
				feed.setCreateDate(rset.getDate("CREATE_DATE"));
				list.add(feed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 
		return list;
	}

	public ArrayList<Feed> searchContent(Connection conn, String searchType, String keyword) {
		ArrayList<Feed> list = new ArrayList<>();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("searchContent"); 
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
	       
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Feed feed = new Feed();
				feed.setFeedNo(rset.getInt("FEED_NO"));
				feed.setFeedTitle(rset.getString("FEED_TITLE"));
				feed.setFeedContent(rset.getString("FEED_CONTENT"));
				feed.setMemberNo(rset.getString("MEMBER_ID"));
				feed.setCount(rset.getInt("COUNT"));
				feed.setCreateDate(rset.getDate("CREATE_DATE"));
				list.add(feed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		 
		return list;
	}

	public ArrayList<Feed> searchTitle(Connection conn, String searchType, String keyword) {
		ArrayList<Feed> list = new ArrayList<>();
		 PreparedStatement pstmt = null;
		 ResultSet rset = null;
		 String sql = prop.getProperty("searchTitle"); 
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
		
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Feed feed = new Feed();
				feed.setFeedNo(rset.getInt("FEED_NO"));
				feed.setFeedTitle(rset.getString("FEED_TITLE"));
				feed.setFeedContent(rset.getString("FEED_CONTENT"));
				feed.setMemberNo(rset.getString("MEMBER_ID"));
				feed.setCount(rset.getInt("COUNT"));
				feed.setCreateDate(rset.getDate("CREATE_DATE"));
				list.add(feed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
	        JDBCTemplate.close(pstmt);
		}
		 
		return list;
	}


	
}
