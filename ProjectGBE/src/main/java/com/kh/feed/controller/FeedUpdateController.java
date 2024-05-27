package com.kh.feed.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;

import com.kh.common.MyFileRenamePolicy;
import com.kh.feed.model.service.FeedService;
import com.kh.feed.model.vo.Attachment;
import com.kh.feed.model.vo.Category;
import com.kh.feed.model.vo.Feed;
import com.kh.marathon.model.service.MarathonService;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class FeedUpdateController
 */
@WebServlet("/update.fe")
public class FeedUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONArray marathonArr = new MarathonService().selectMarathon();
		request.setAttribute("marathonArr", marathonArr);
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		FeedService fs = new FeedService();
		
		Feed f = fs.selectFeed(fno);
		
		ArrayList<Category> cList = fs.selectCategoryList();
		
		Attachment at = fs.selectAttachment(fno);
		
		request.setAttribute("f", f);
		request.setAttribute("cList", cList);
		request.setAttribute("at", at);
		
		request.getRequestDispatcher("views/feed/feedUpdateView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
		
		String savePath = request.getSession().getServletContext().getRealPath("/views/feed/uploadFile/");	
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
		
		int feedNo = Integer.parseInt(multiRequest.getParameter("feedNo"));
		String title = multiRequest.getParameter("title");
		String content = multiRequest.getParameter("content");
		String category = multiRequest.getParameter("category");
		String competition = multiRequest.getParameter("competition");
		
		Feed f = new Feed();
		f.setFeedNo(feedNo);
		f.setFeedTitle(title);
		f.setFeedContent(content);
		f.setCategoryNo(category);
		f.setCompetition(competition);
		
		
		Attachment at = null;
		
		if(multiRequest.getOriginalFileName("reUploadFile")!=null) {
			
			at = new Attachment();
			
			at.setOriginName(multiRequest.getOriginalFileName("reUploadFile"));
			
			at.setChangeName(multiRequest.getFilesystemName("reUploadFile"));
			at.setFilePath("/views/feed/uploadFile/");
			
			if(multiRequest.getParameter("originFileNo")!=null) {
				at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
				
			}else {
				at.setRefBno(feedNo);
			}
		}
		int result = new FeedService().updateFeed(f,at);
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "게시글 수정완료");
			response.sendRedirect(request.getContextPath()+"/detail.fe?fno="+feedNo);
			
			if(at!=null && at.getFileNo()!=0) {
				new File(savePath+multiRequest.getParameter("originFileName")).delete();
			}
		}else {
			session.setAttribute("alertMsg", "게시글 수정실패");
			response.sendRedirect(request.getContextPath()+"/list.fe?currentPage=1");
		}
		}
	}

}
