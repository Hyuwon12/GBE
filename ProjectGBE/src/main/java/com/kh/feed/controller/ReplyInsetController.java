package com.kh.feed.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.feed.model.service.FeedService;
import com.kh.feed.model.vo.Reply;

/**
 * Servlet implementation class ReplyInsetController
 */
@WebServlet("/insertReply.fe")
public class ReplyInsetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsetController() {
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
		
		String memberId = request.getParameter("memberNo");
		int fno = Integer.parseInt(request.getParameter("fno"));
		String content = request.getParameter("content");
		
		Reply r = new Reply();
		r.setRefBno(fno);
		r.setMemberNo(memberId);
		r.setReplyContent(content);
		
		int result = new FeedService().insertReply(r);
		
		response.getWriter().print(result);
		
		
	}

}
