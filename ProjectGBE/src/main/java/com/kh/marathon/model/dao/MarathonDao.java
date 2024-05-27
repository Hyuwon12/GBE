package com.kh.marathon.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.common.JDBCTemplate;
import com.kh.marathon.model.vo.Marathon;

public class MarathonDao{
	private Properties prop = new Properties();
	
	public MarathonDao() {
		String filePath = MarathonDao.class.getResource("/resources/sql/marathon-mapper.xml").getPath();		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertMarathon(Connection conn, JSONObject jobj) {
        PreparedStatement pstmt =null;
        String sql = prop.getProperty("insertMarathon");
        int result =0;
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, (String) jobj.get("marathonName"));
            pstmt.setString(2, (String) jobj.get("location"));
            pstmt.setString(3, (String) jobj.get("region"));
            pstmt.setString(4, (String) jobj.get("marathonDate"));
            pstmt.setString(5, (String) jobj.get("applicationDate"));
            pstmt.setString(6, (String) jobj.get("otherIntroduction"));
            pstmt.setString(7, (String) jobj.get("organizer"));
            pstmt.setString(8, (String) jobj.get("organizerHost"));
            pstmt.setString(9, (String) jobj.get("organizerPhone"));            
            pstmt.setString(10, (String) jobj.get("marathonSite"));
            pstmt.setInt(11, (Integer) jobj.get("imageNo"));
            pstmt.setString(12, (String) jobj.get("marathonCourse"));
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }
	public int deleteAllMarathon(Connection conn) {
		int result = 0;
		Statement stmt = null;
		String sql=prop.getProperty("deleteAllMarathon");
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	public JSONArray selectMarathon(Connection conn) {
		JSONArray MarathonArr = new JSONArray();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMarathon");
		try {
			stmt=conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("marathonNo",rset.getString("MARATHON_NO"));
				jobj.put("marathonName",rset.getString("MARATHON_NAME"));
				jobj.put("location",rset.getString("LOCATION"));
				jobj.put("region",rset.getString("REGION"));
				jobj.put("marathonDate",rset.getString("MARATHON_DATE").substring(0, rset.getString("MARATHON_DATE").indexOf(" ")));
				jobj.put("marathonSite",rset.getString("MARATHON_SITE"));
				jobj.put("organizer", rset.getString("ORGANIZER"));
				String otherIntroduction = rset.getString("OTHER_INTRODUCTION");
				if(otherIntroduction!=null&&otherIntroduction.length()>50) {
					otherIntroduction = otherIntroduction.substring(0,50);
				}
				jobj.put("otherIntroduction", otherIntroduction);
				jobj.put("imageNo", rset.getInt("IMAGE_NO"));
				MarathonArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return MarathonArr;
	}
	public Marathon marathonDetail(Connection conn, int marathonNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("marathonDetail");
		Marathon mar = new Marathon();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,marathonNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mar = new Marathon(rset.getInt("MARATHON_NO")
											,rset.getString("MARATHON_NAME")
											,rset.getString("LOCATION")
											,rset.getString("REGION")
											,rset.getString("MARATHON_DATE")
											,rset.getString("APPLICATION_DATE")
											,rset.getString("OTHER_INTRODUCTION")
											,rset.getString("ORGANIZER")
											,rset.getString("ORGANIZER_HOST")
											,rset.getString("ORGANIZER_PHONE")
											,rset.getString("MARATHON_SITE")
											,rset.getString("STATUS")
											,rset.getInt("IMAGE_NO")
											,rset.getString("MARATHON_COURSE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mar;
	}
	public int updateMarathon(Marathon m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMarathon");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMarathonName());
			pstmt.setString(2, m.getLocation());
			pstmt.setString(3, m.getRegion());
			pstmt.setString(4, m.getMarathonCourse());
			pstmt.setString(5, m.getMarathonDate());
			pstmt.setString(6, m.getApplicationDate());
			pstmt.setString(7, m.getOtherIntroduction());
			pstmt.setString(8, m.getOrganizer());
			pstmt.setString(9, m.getOrganizerHost());
			pstmt.setString(10, m.getOrganizerPhone());
			pstmt.setString(11, m.getMarathonSite());
			pstmt.setInt(12, m.getMarathonNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	public int deleteMarathon(int marathonNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMarathon");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, marathonNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	
	public int restoreMarathon(int marathonNo, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("restoreMarathon");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, marathonNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}
	public JSONArray selectDeleteMarathon(Connection conn) {
		JSONArray marathonArr = new JSONArray();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDeleteMarathon");
		try {
			stmt=conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("marathonNo",rset.getString("MARATHON_NO"));
				jobj.put("marathonName",rset.getString("MARATHON_NAME"));
				jobj.put("location",rset.getString("LOCATION"));
				jobj.put("region",rset.getString("REGION"));
				jobj.put("marathonDate",rset.getString("MARATHON_DATE").substring(0, rset.getString("MARATHON_DATE").indexOf(" ")));
				jobj.put("marathonSite",rset.getString("MARATHON_SITE"));
				jobj.put("organizer", rset.getString("ORGANIZER"));
				String otherIntroduction = rset.getString("OTHER_INTRODUCTION");
				if(otherIntroduction!=null&&otherIntroduction.length()>50) {
					otherIntroduction = otherIntroduction.substring(0,50);
				}
				jobj.put("otherIntroduction", otherIntroduction);
				marathonArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return marathonArr;
	}
	public String selectMarathonRegionName(Connection conn, int marathonNo) {
		String regionName = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMarathonRegionName");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, marathonNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				regionName=rset.getString("REGION");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return regionName;
	}
	public JSONArray selectSearch(Connection conn, String searchName) {
		JSONArray searchArr = new JSONArray();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSearch");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setString(2, "%"+searchName+"%");
			pstmt.setString(3, "%"+searchName+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				JSONObject jobj = new JSONObject();
				jobj.put("marathonNo",rset.getString("MARATHON_NO"));
				jobj.put("marathonName",rset.getString("MARATHON_NAME"));
				jobj.put("location",rset.getString("LOCATION"));
				jobj.put("region",rset.getString("REGION"));
				jobj.put("marathonDate",rset.getString("MARATHON_DATE").substring(0, rset.getString("MARATHON_DATE").indexOf(" ")));
				jobj.put("marathonSite",rset.getString("MARATHON_SITE"));
				jobj.put("organizer", rset.getString("ORGANIZER"));
				String otherIntroduction = rset.getString("OTHER_INTRODUCTION");
				if(otherIntroduction!=null&&otherIntroduction.length()>50) {
					otherIntroduction = otherIntroduction.substring(0,50);
				}
				jobj.put("otherIntroduction", otherIntroduction);
				jobj.put("imageNo", rset.getInt("IMAGE_NO"));
				searchArr.add(jobj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return searchArr;
	}

}