package com.kh.feed.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.feed.model.service.FeedService;
import com.kh.feed.model.vo.Reply;

/**
 * Servlet implementation class deleteReplyController
 */
@WebServlet("/deleteReply.fe")
public class deleteReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		String memberNo = request.getParameter("memberNo");
		
		Reply r = new Reply();
		r.setReplyNo(replyNo);
		r.setMemberNo(memberNo);
		int result = new FeedService().deleteReply(r);
		
		response.getWriter().print(result);
		
		
	}

}




