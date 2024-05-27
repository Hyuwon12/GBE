package com.kh.feed.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.feed.model.service.FeedService;

/**
 * Servlet implementation class FeedDeleteController
 */
@WebServlet("/delete.fe")
public class FeedDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int feedNo = Integer.parseInt(request.getParameter("fno"));
		
		int result = new FeedService().deleteFeed(feedNo);
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "게시글 삭제 성공");
			response.sendRedirect(request.getContextPath()+"/list.fe?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "게시글 삭제 실패");
			response.sendRedirect(request.getContextPath()+"/detail.fe?fno="+feedNo);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
