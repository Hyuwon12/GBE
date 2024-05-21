package com.kh.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.training.model.service.TrainingService;

/**
 * Servlet implementation class TrainingDeleteController
 */
@WebServlet("/delete.tr")
public class TrainingDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tno = Integer.parseInt(request.getParameter("tno"));
		int result = new TrainingService().deleteTraining(tno);
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "일지가 삭제되었습니다");
			request.getRequestDispatcher("/list.tr?currentPage=1").forward(request, response);

		}else {
			session.setAttribute("alertMsg", "일지 삭제 실패ㅠㅠ");
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
