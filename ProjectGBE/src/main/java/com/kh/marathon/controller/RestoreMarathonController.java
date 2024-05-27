package com.kh.marathon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.kh.marathon.model.service.MarathonService;

/**
 * Servlet implementation class RestoreMarathonController
 */
@WebServlet("/restore.ma")
public class RestoreMarathonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestoreMarathonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray marathonArr = new MarathonService().selectDeleteMarathon();
		request.setAttribute("marathonArr", marathonArr);
		request.getRequestDispatcher("views/marathon/marathonRestoreView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marathonNo = Integer.parseInt(request.getParameter("marathonNo"));
		int result = new MarathonService().restoreMarathon(marathonNo);
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "복구 성공");				
		}else {
			request.getSession().setAttribute("alertMsg", "복구 실패");
		}
		response.sendRedirect(request.getContextPath()+"/list.ma");
	}

}
