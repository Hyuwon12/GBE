package com.kh.feed.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.feed.model.service.FeedService;
import com.kh.feed.model.vo.Feed;


/**
 * Servlet implementation class SearchFeedController
 */
@WebServlet("/search.fe")
public class SearchFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFeedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<Feed> searchList = null;
		 
		 String searchType = request.getParameter("searchType");
	     String keyword = request.getParameter("keyword");
	     
	     FeedService service = new FeedService();
	     searchList = service.searchFeedList(searchType,keyword);
	     
	     request.setAttribute("searchList", searchList);
	     
	     RequestDispatcher dispatcher = request.getRequestDispatcher("/views/feed/searchResult.jsp");
	     dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
