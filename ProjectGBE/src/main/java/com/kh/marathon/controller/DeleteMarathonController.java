package com.kh.marathon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.marathon.model.service.MarathonService;
import com.kh.marathon.model.vo.Marathon;

/**
 * Servlet implementation class DeleteMarathonController
 */
@WebServlet("/delete.ma")
public class DeleteMarathonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMarathonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marathonNo = Integer.parseInt(request.getParameter("marathonNo"));
		int result = new MarathonService().deleteMarathon(marathonNo);
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "삭제 성공");				
		}else {
			request.getSession().setAttribute("alertMsg", "삭제 실패");
		}
		response.sendRedirect(request.getContextPath()+"/list.ma");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
