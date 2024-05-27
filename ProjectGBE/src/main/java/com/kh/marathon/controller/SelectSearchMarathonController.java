package com.kh.marathon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.google.gson.Gson;
import com.kh.marathon.model.service.MarathonService;

/**
 * Servlet implementation class SelectSearchMarathonController
 */
@WebServlet("/search.ma")
public class SelectSearchMarathonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSearchMarathonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchName = request.getParameter("searchName");
		JSONArray searchArr = new MarathonService().selectSearch(searchName);
		int contentCount= searchArr.size();

		request.setAttribute("marathonArr", searchArr);
		request.setAttribute("contentCount", contentCount);
		request.setAttribute("searchName", searchName);
		request.getRequestDispatcher("views/marathon/searchMarathon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
