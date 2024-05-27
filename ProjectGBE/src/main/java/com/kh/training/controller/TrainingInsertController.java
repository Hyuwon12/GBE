package com.kh.training.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.training.model.service.TrainingService;
import com.kh.training.model.vo.Attachment;
import com.kh.training.model.vo.Shoes;
import com.kh.training.model.vo.Training;
import com.kh.training.model.vo.TrainingCategory;
import com.kh.training.model.vo.TrainingImgNamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertTrainingController
 */
@WebServlet("/insert.tr")
public class TrainingInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainingInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 훈련종류 리스트 DB에서 가져오는 메서드
		ArrayList<TrainingCategory> tCList = new TrainingService().selectCategoryList();
		ArrayList<Shoes> sList = new TrainingService().selectShoesList();
		request.setAttribute("tCList", tCList);
		request.setAttribute("sList", sList);

		request.getRequestDispatcher("views/training/trainingInsertView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/views/training/uploadImg/");

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new TrainingImgNamePolicy());

			String trainingTitle = multiRequest.getParameter("trainingTitle");
			String trainingKey = multiRequest.getParameter("category");
			int shoesNo = Integer.parseInt(multiRequest.getParameter("shoes"));
			String trainingDate = multiRequest.getParameter("trainingDate");
			// String shoes = request.getParameter("shoes"); 러닝화 기능 구현되면 가져올 것
			String trainingPlace = multiRequest.getParameter("trainingPlace");
			double trainingDistance = Double.parseDouble(multiRequest.getParameter("trainingDistance"));
			double trainingTime = Double.parseDouble(multiRequest.getParameter("trainingTime"));
			String trainingGoal = multiRequest.getParameter("trainingGoal");
			double weight = Double.parseDouble(multiRequest.getParameter("weight"));
			String trainingContent = multiRequest.getParameter("trainingContent");
			boolean open = multiRequest.getParameter("secret") != null;

			Training t = new Training();
			t.setTrainingTitle(trainingTitle);
			t.setShoesNo(shoesNo);
			t.setTrainingKey(trainingKey);
			t.setTrainingDate(trainingDate);
			t.setTrainingPlace(trainingPlace);
			t.setTrainingDistance(trainingDistance);
			t.setTrainingTime(trainingTime);
			t.setTrainingGoal(trainingGoal);
			t.setWeight(weight);
			t.setTrainingContent(trainingContent);
			if (open) {
				t.setoCStatus("C");
			} else {
				t.setoCStatus("O");
			}

			int memberNo = Integer.parseInt(multiRequest.getParameter("memberNo"));

			Attachment at = null;
			if (multiRequest.getOriginalFileName("uploadImg") != null) {
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("uploadImg"));
				at.setChangeName(multiRequest.getFilesystemName("uploadImg"));
				at.setFilePath("/views/training/uploadImg/");
			}
			int result = new TrainingService().insertTraining(t, at, memberNo);

			HttpSession session = request.getSession();
			if (result > 0) {
				session.setAttribute("alertMsg", "게시글 작성 성공");
				request.getRequestDispatcher("/detail.tr?tno=" + t.getTrainingNo()).forward(request, response);
			} else {
//				if(at!=null) {
//					게시글 작성 실패시 파일 삭제하는 기능 구현
//				}
				session.setAttribute("alertMsg", "게시글 작성 실패");
				response.sendRedirect(request.getContextPath());
			}
//		System.out.println(trainingTitle);
//		System.out.println(category);
//		System.out.println(trainingPlace);
//		System.out.println(trainingDistance);
//		System.out.println(trainingTime);
//		System.out.println(trainingGoal);
//		System.out.println(weight);
//		System.out.println(trainingContent); 값 제대로 받아지는지 확인
		}

	}
}