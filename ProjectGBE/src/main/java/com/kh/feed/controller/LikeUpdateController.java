package com.kh.feed.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.feed.model.service.FeedService;

/**
 * Servlet implementation class LikeUpdateController
 */
@WebServlet("/like.fe")
public class LikeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeUpdateController() {
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
		
	        int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	        int feedNo = Integer.parseInt(request.getParameter("feedNo"));
	        String action = request.getParameter("action");
	        

	        
	        FeedService feedService = new FeedService();
	        int result = 0;

	        if (action.equals("add")) {
	            result = feedService.addLike(feedNo, memberNo);
	        } else if (action.equals("remove")) {
	            result = feedService.removeLike(feedNo, memberNo);
	            
	        }
	        result = feedService.selectLike(feedNo);
	        
	        // 결과를 JSON 형식으로 응답
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(result);
	        out.flush();
	        
	        
	       
	    }
	   }
	
	



