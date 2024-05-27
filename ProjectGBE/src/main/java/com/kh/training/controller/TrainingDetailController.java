package com.kh.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.training.model.service.TrainingService;
import com.kh.training.model.vo.Attachment;
import com.kh.training.model.vo.Shoes;
import com.kh.training.model.vo.Training;

/**
 * Servlet implementation class TrainingDetailController
 */
@WebServlet("/detail.tr")
public class TrainingDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));
//		
		int result = new TrainingService().increaseCount(tno);
		if (result>0) {
			Training t = new TrainingService().selectTraining(tno);
			Attachment at = new TrainingService().selectAttachment(tno);
			Shoes s = new TrainingService().selectShoes(tno);
			request.setAttribute("training", t);
			request.setAttribute("attachment", at);
			request.setAttribute("shoes", s);
			request.getRequestDispatcher("views/training/trainingDetailView.jsp").forward(request, response);
			
		}else {
			request.getSession().setAttribute("alertMsg", "일지 조회 실패ㅠㅠ");
			response.sendRedirect(request.getHeader("referer"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
