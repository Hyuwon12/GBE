package com.kh.marathon.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.kh.marathon.model.service.MarathonService;
import com.kh.marathon.model.service.ParticipateService;
import com.kh.marathon.model.vo.Marathon;
import com.kh.marathon.model.vo.Participate;

/**
 * Servlet implementation class MarathonDetailController
 */
@WebServlet("/detail.ma")
public class MarathonDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarathonDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marathonNo = Integer.parseInt(request.getParameter("marathonNo"));
		Marathon mar = new MarathonService().marathonDetail(marathonNo);
		ArrayList<Participate> participateList = new ParticipateService().listParticipate(marathonNo);
		request.setAttribute("participateList", participateList);
		request.setAttribute("mar", mar);
		request.getRequestDispatcher("views/marathon/marathonDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
