package com.kh.feed.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.feed.model.service.FeedService;
import com.kh.feed.model.vo.Attachment;
import com.kh.feed.model.vo.Feed;

/**
 * Servlet implementation class DetailFeedController
 */
@WebServlet("/detail.fe")
public class DetailFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailFeedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		int result = new FeedService().increaseCount(fno);
		
		if(result>0) {
			Feed f = new FeedService().selectFeed(fno);
			
			Attachment at = new FeedService().selectAttachment(fno);
			
			request.setAttribute("f", f);
			request.setAttribute("at", at);
			
			request.getRequestDispatcher("views/feed/feedDetailView.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("alertMsg", "조회실패");
			response.sendRedirect(request.getHeader("referer"));
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
