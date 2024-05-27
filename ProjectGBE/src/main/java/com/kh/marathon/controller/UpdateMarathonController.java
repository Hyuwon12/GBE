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
 * Servlet implementation class UpdateMarathonController
 */
@WebServlet("/update.ma")
public class UpdateMarathonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMarathonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청들어오면 테이블내의 데이터를 비우고 insert 관리자만 실행시킬수있게 처리
			int marathonNo = Integer.parseInt(request.getParameter("marathonNo"));
			Marathon mar = new MarathonService().marathonDetail(marathonNo);
			request.setAttribute("mar", mar);
			request.getRequestDispatcher("views/marathon/updateMarathonView.jsp").forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		Marathon m = new Marathon();
		int marathonNo =  Integer.parseInt(request.getParameter("marathonNo"));
		String marathonName = request.getParameter("marathonName");
		String region = request.getParameter("region");
		String location = request.getParameter("location");
		String marathonCourse = request.getParameter("marathonCourse");
		String marathonDate = request.getParameter("marathonDate");
		String applicationDate = request.getParameter("applicationDate");
		String organizer = request.getParameter("organizer");
		String organizerHost = request.getParameter("organizerHost");
		String organizerPhone = request.getParameter("organizerPhone");
		String marathonSite = request.getParameter("marathonSite");
		String otherIntroduction = request.getParameter("otherIntroduction");
		m.setMarathonNo(marathonNo);
		m.setMarathonName(marathonName);
		m.setRegion(region);
		m.setLocation(location);
		m.setMarathonCourse(marathonCourse);
		m.setMarathonDate(marathonDate);
		m.setApplicationDate(applicationDate);
		m.setOrganizer(organizer);
		m.setOrganizerHost(organizerHost);
		m.setOrganizerPhone(organizerPhone);
		m.setMarathonSite(marathonSite);
		m.setOtherIntroduction(otherIntroduction);
		int result = new MarathonService().updateMarathon(m);
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "변경 성공");				
			}else {
				request.getSession().setAttribute("alertMsg", "변경 실패");
			}
		response.sendRedirect(request.getContextPath()+"/detail.ma?marathonNo="+marathonNo);
	}

}
