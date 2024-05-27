package com.kh.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.training.model.service.TrainingService;

/**
 * Servlet implementation class UpdateReplyController
 */
@WebServlet("/ureply.tr")
public class UpdateReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));
		int result = new TrainingService().updateLikes(tno);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyWriter = request.getParameter("replyWriter");
		String originReply = request.getParameter("originReply");
		String changeReply = request.getParameter("changeReply");
		int refTno = Integer.parseInt(request.getParameter("refTno"));
		int result = new TrainingService().updateReply(replyWriter,originReply,changeReply,refTno);
		response.getWriter().print(result);
	}

}
