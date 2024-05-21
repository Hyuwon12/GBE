package com.kh.training.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.training.model.service.TrainingService;
import com.kh.training.model.vo.Reply;

/**
 * Servlet implementation class ReplyInsertController
 */
@WebServlet("/reply.tr")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int refTno = Integer.parseInt(request.getParameter("tno"));
		
		ArrayList<Reply> list = new TrainingService().selectReplyList(refTno);
		response.setContentType("json/application; charset=UTF-8");
		
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberNo = request.getParameter("memberNo");
		int tno = Integer.parseInt(request.getParameter("tno"));
		String reply = request.getParameter("reply");

		Reply r = new Reply();
		r.setRefTno(tno);
		r.setreplyWriter(memberNo);
		r.setreplyContent(reply);
		
		int result = new TrainingService().insertReply(r);
		response.getWriter().print(result);
	}

}
