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
 * Servlet implementation class InsertFeedController
 */
@WebServlet("/insert.fe")
public class InsertFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONArray marathonArr = new MarathonService().selectMarathon();
		request.setAttribute("marathonArr", marathonArr);
		
		ArrayList<Category> cList = new FeedService().selectCategoryList();
		
		request.setAttribute("cList", cList);
		
		request.getRequestDispatcher("views/feed/feedInsertView.jsp").forward(request, response);
		
		
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
		
		String category = multiRequest.getParameter("category");
		String title = multiRequest.getParameter("title");
		String content = multiRequest.getParameter("content");
		String memberId = multiRequest.getParameter("memberNo");
		String competition = multiRequest.getParameter("competition");
		
		
		Feed f = new Feed();
		f.setCategoryNo(category);
		f.setFeedTitle(title);
		f.setFeedContent(content);
		f.setMemberNo(memberId);
		f.setCompetition(competition);
				
		
		Attachment at = null;
		
		if(multiRequest.getOriginalFileName("uploadFile") != null) {
			at = new Attachment();
			at.setOriginName(multiRequest.getOriginalFileName("uploadFile")); //원본파일명
			at.setChangeName(multiRequest.getFilesystemName("uploadFile")); //서버에 업로드되어있는 파일명
			at.setFilePath("/views/feed/uploadFile/");
		}
		int result = new FeedService().insertFeed(f,at);
		
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "게시글 등록 성공");
			response.sendRedirect(request.getContextPath()+"/list.fe?currentPage=1");
		}else {
			if(at!=null) {
				new File(savePath+at.getChangeName()).delete();
			}
		session.setAttribute("alertMsg", "게시글 등록 실패");
		response.sendRedirect(request.getContextPath()+"/list.fe?currentPage=1");
		}
		
		}
		
	}

}
