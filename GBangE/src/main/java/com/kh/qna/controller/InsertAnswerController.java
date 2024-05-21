package com.kh.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.google.gson.Gson;
import com.kh.qna.model.service.QnAService;
import com.kh.qna.model.vo.Answer;

/**
 * Servlet implementation class InsertAnswerController
 */
@WebServlet("/insert.an")
public class InsertAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAnswerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String answerTitle = request.getParameter("answerTitle");
		String answerContent = request.getParameter("answerContent");
		Answer a = new Answer();
		a.setRefQno(questionId);
		a.setAnswerTitle(answerTitle);
		a.setAnswerContent(answerContent);
		a.setMemberNo(memberNo);
		int result = new QnAService().insertAnswer(a);
		String alertMsg = "";
		if(result>0) {
			alertMsg = "등록 완료";
		}else {
			alertMsg = "등록 실패";
		}
		request.setAttribute("alertMsg",alertMsg);
		JSONArray answerArr = new QnAService().selectAnswer(questionId);
		response.setContentType("json/application;charset=utf-8");
		new Gson().toJson(answerArr,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
