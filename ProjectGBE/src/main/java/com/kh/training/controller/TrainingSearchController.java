package com.kh.training.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.training.model.service.TrainingService;
import com.kh.training.model.vo.Training;

/**
 * Servlet implementation class TrainingSearchController
 */
@WebServlet("/search.tr")
public class TrainingSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainingSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//페이징 처리 시작
		int listCount; //총 게시글 개수
		int currentPage; //현재 페이지
		int pageLimit; //페이지 하단에 포여질 페이징바의 최개 개수
		int boardLimit; //한 페이지에 보여질 게시글 개수
		
		int maxPage; //가장 마지막에 보여질 페이징바가 몇번인지 (총 페이지 개수)
		int startPage; //페이지 하단에 보여질 페이징바의 시작수
		int endPage; //페이지 하단에 보여질 페이징바의 끝수
		
		listCount = new TrainingService().listCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1)/pageLimit * pageLimit +1;
		
		endPage = startPage+pageLimit-1;
		
		if (endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		//페이징 처리 끝
		
		ArrayList<Training> searchList = new ArrayList<>();
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		switch (searchType) {
		case "title": 
			searchList = new TrainingService().searchByTitle(pi,keyword);
			break;
		case "trainingCategory":
			searchList = new TrainingService().searchByCategory(pi,keyword);
			break;
		case "titleContent":
			searchList = new TrainingService().searchByContent(pi,keyword);
			break;
		}
		request.setAttribute("pi", pi);
		request.setAttribute("keyword", keyword);
		request.setAttribute("searchList", searchList);
		
		request.getRequestDispatcher("/views/training/searchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
