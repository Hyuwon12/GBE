package com.kh.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.qna.model.service.QnAService;
import com.kh.qna.model.vo.Question;

/**
 * Servlet implementation class insertQusetionController
 */
@WebServlet("/insert.qu")
public class insertQusetionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertQusetionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/QnA/insertQuestion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String questionTitle = request.getParameter("questionTitle");
		String questionContent = request.getParameter("questionContent");
		Question q = new Question();
		q.setMemberNo(memberNo);
		q.setQuestionTitle(questionTitle);
		q.setQuestionContent(questionContent);
		int result = new QnAService().insertQuestion(q);
		String alertMsg = "";
		if(result>0) {
			alertMsg = "작성 성공";
		}else {
			alertMsg = "작성 실패";
		}
		request.setAttribute("alertMsg", alertMsg);
		response.sendRedirect(request.getContextPath()+"/list.qu");
	}

}
