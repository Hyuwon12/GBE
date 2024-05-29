package com.kh.marathon.model.service;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.common.JDBCTemplate;
import com.kh.marathon.model.dao.MarathonDao;
import com.kh.marathon.model.vo.Marathon;

@Service
public class MarathonServiceImpl implements MarathonService{
	
	@Autowired
	private MarathonDao marathonDao;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String baseURL = "http://www.roadrun.co.kr/schedule/list.php";
	@Override
    public int insertMarathon(){
        int result=0;
        ArrayList<Marathon> mArr = crawling();
        for (int i=0;i<mArr.size();i++){
            Marathon m = mArr.get(i);
            result = new MarathonDao().insertMarathon(sqlSession,m);
            if(result<0){
                break;
            }
        }
        return result;
    }
    
    public ArrayList<Marathon> crawling(){
        Document doc = null;
        try {
            //jsoup 라이브러리 등록
            doc = Jsoup.connect(baseURL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Marathon> mArr = new ArrayList<Marathon>();
        // 
        int num =Integer.parseInt(doc.select("font[color=red]").first().text());
        Document doc2=null;
        int count =1;
        for(int i=0;i<num;i++) {
            try {
                String href = doc.select("td[width=29%] a").eq(i).attr("href");
                if (href.isEmpty()) {
                    System.out.println("초기화"+new Date());
                    break;
                }
                String subHref = href.substring(href.indexOf(",") + 3, href.indexOf(",", href.indexOf(",") + 1) - 1);
                String URL2 = "http://www.roadrun.co.kr/schedule/" + subHref;

                //가져온 주소로 새로 크롤링
                doc2 = Jsoup.parse(new URL(URL2).openStream(), "euc-kr", URL2);
                String marathonName = doc2.select("td[width=430]").eq(0).text();
                String location = doc2.select("td[width=430]").eq(7).text();
                String marathonDate = doc2.select("td[width=430]").eq(3).text();
                String applicationDate = doc2.select("td[width=430]").eq(9).text();
                String organizer = doc2.select("td[width=430]").eq(1).text();
                String organizerPhone = doc2.select("td[width=430]").eq(4).text();
                String organizerHost = doc2.select("td[width=430]").eq(8).text();
                String region = doc2.select("td[width=430]").eq(6).text();
                String marathonSite = doc2.select("td[width=430]").eq(10).text();
                String otherIntroduction = doc2.select("td[width=430]").eq(11).text();
                String marathonCourse = doc2.select("td[width=430]").eq(5).text();
                
                Marathon m = new Marathon(marathonName, location, region, marathonDate, applicationDate, otherIntroduction, organizer, organizerHost, organizerPhone, marathonSite, count++, marathonCourse);
                mArr.add(m);
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mArr;
    }
    @Override
	public int deleteAllMarathon() {		
		return marathonDao.deleteAllMarathon(sqlSession);
	}
    @Override
	public ArrayList<Marathon> selectMarathon() {		
		return marathonDao.selectMarathon(sqlSession);
	}
    @Override
	public int deleteMarathon(int marathonNo) {
		return marathonDao.deleteMarathon(sqlSession, marathonNo);
	}
    @Override
	public Marathon marathonDetail(int marathonNo) {		
		return marathonDao.marathonDetail(sqlSession,marathonNo);
	}
    @Override
	public ArrayList<Marathon> selectDeleteMarathon() {		
		return marathonDao.selectDeleteMarathon(sqlSession);
	}
    @Override
	public int restoreMarathon(int marathonNo) {
		return marathonDao.restoreMarathon(sqlSession, marathonNo);
	}
    @Override
	public int updateMarathon(Marathon m) {
		return marathonDao.updateMarathon(sqlSession,m);
	}	
    @Override
	public String selectMarathonRegionName(int marathonNo) {		
		return marathonDao.selectMarathonRegionName(sqlSession, marathonNo);
	}
	@Override
	public ArrayList<Marathon> searchMarathon(String searchName) {
		return marathonDao.searchMarathon(sqlSession,searchName);
	}
}
