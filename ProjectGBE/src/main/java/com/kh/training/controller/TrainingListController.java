package com.kh.training.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.training.model.service.TrainingService;
import com.kh.training.model.vo.Training;

/**
 * Servlet implementation class TrainingListController
 */
@WebServlet("/list.tr")
public class TrainingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리
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
		
		ArrayList<Training> list = new TrainingService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list",list);
		request.getRequestDispatcher("views/training/trainingListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
