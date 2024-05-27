package com.kh.training.controller;

import java.io.File;
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
 * Servlet implementation class TrainingUpdateController
 */
@WebServlet("/update.tr")
public class TrainingUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainingUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));

		TrainingService ts = new TrainingService();

		Training t = ts.selectTraining(tno);

		ArrayList<TrainingCategory> tCList = ts.selectCategoryList();
		Attachment at = ts.selectAttachment(tno);
		ArrayList<Shoes> sList = ts.selectShoesList();
		Shoes s = ts.selectShoes(tno);
		request.setAttribute("training", t);
		request.setAttribute("tCList", tCList);
		request.setAttribute("attachment", at);
		request.setAttribute("sList", sList);
		request.setAttribute("shoes", s);
		request.getRequestDispatcher("views/training/trainingUpdateView.jsp").forward(request, response);

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

			int trainingNo = Integer.parseInt(multiRequest.getParameter("trainingNo"));
			String trainingTitle = multiRequest.getParameter("trainingTitle");
			boolean open = multiRequest.getParameter("secret") != null;
			String trainingDate = multiRequest.getParameter("trainingDate");
			String trainingKey = multiRequest.getParameter("category");
			/* int shoes = shoes 기능 */
			String trainingPlace = multiRequest.getParameter("trainingPlace");
			double trainingDistance = Double.parseDouble(multiRequest.getParameter("trainingDistance"));
			double trainingTime = Double.parseDouble(multiRequest.getParameter("trainingTime"));
			String trainingGoal = multiRequest.getParameter("trainingGoal");
			double weight = Double.parseDouble(multiRequest.getParameter("weight"));
			String trainingContent = multiRequest.getParameter("trainingContent");

			Training t = new Training();
			t.setTrainingNo(trainingNo);
			t.setTrainingTitle(trainingTitle);
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

			Attachment at = null;
			if (multiRequest.getOriginalFileName("reUploadImg") != null) {
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("reUploadImg"));
				at.setChangeName(multiRequest.getFilesystemName("reUploadImg"));
				at.setFilePath("/views/training/uploadImg/");

				if (multiRequest.getParameter("originFileNo") != null) {
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
				} else {
					at.setRefBno(trainingNo);
				}
			}
			
			int result = new TrainingService().updateTraining(t, at);
			
			HttpSession session = request.getSession();
			if(result>0) {
				session.setAttribute("alertMsg", "게시글 수정완료");
				response.sendRedirect(request.getContextPath()+"/detail.tr?tno="+trainingNo);
				if(at!=null && at.getFileNo()!=0) {
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
				}
			}else {
				session.setAttribute("alertMsg", "게시글 수정실패ㅠㅠ");
				response.sendRedirect(request.getContextPath()+"/detail.tr?tno="+trainingNo);
			}
//			System.out.println(trainingNo);
//			System.out.println(trainingTitle);
//			System.out.println(trainingDate);
//			System.out.println(open);
//			System.out.println(trainingKey);
//			System.out.println(trainingPlace);
//			System.out.println(trainingDistance);
//			System.out.println(trainingTime);
//			System.out.println(trainingGoal);
//			System.out.println(weight);
//			System.out.println(trainingContent); // 데이터가 제대로 넘어왔는지 확인
//			System.out.println(multiRequest.getOriginalFileName("reUploadImg"));
//			System.out.println(multiRequest.getParameter("originFileNo"));
		}
	}

}
