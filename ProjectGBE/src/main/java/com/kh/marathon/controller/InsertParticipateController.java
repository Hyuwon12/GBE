package com.kh.marathon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.marathon.model.service.MarathonService;
import com.kh.marathon.model.service.ParticipateService;
import com.kh.marathon.model.service.RegionService;
import com.kh.marathon.model.vo.Marathon;
import com.kh.marathon.model.vo.Participate;

/**
 * Servlet implementation class InsertParticipateController
 */
@WebServlet("/insert.pa")
public class InsertParticipateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertParticipateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int marathonNo = Integer.parseInt(request.getParameter("marathonNo"));
		Marathon m = new MarathonService().marathonDetail(marathonNo);		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String[] courseList = m.getMarathonCourse().split(",");
		request.setAttribute("marathonName", m.getMarathonName());
		request.setAttribute("marathonNo", m.getMarathonNo());
		request.setAttribute("courseList", courseList);
		request.setAttribute("memberNo", memberNo);
		request.getRequestDispatcher("views/marathon/insertParticipateView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));		
		int marathonNo = Integer.parseInt(request.getParameter("marathonNo"));
		String regionName = new MarathonService().selectMarathonRegionName(marathonNo);
		int regionId = new RegionService().selectRegionId(regionName);
		
		String Name = request.getParameter("participateName");
		String participateCourse = request.getParameter("participateCourse");
		String Pwd = request.getParameter("participatePwd");
		String registerationNo = request.getParameter("registerationNo1")+"-"+request.getParameter("registerationNo2");
		String gender = request.getParameter("gender");
		String participatePhone = request.getParameter("participatePhone");
		
		String sample6_postcode = request.getParameter("sample6_postcode");
		String sample6_address = request.getParameter("sample6_address");
		String sample6_detailAddress = request.getParameter("sample6_detailAddress");
		String sample6_extraAddress = request.getParameter("sample6_extraAddress");
		String address = sample6_postcode+sample6_address+sample6_detailAddress+sample6_extraAddress;
		
		Participate p = new Participate();
		p.setMemberNo(memberNo);
		p.setMarathonNo(marathonNo);
		p.setRegionId(regionId);		
		p.setName(Name);
		p.setParticipateCourse(participateCourse);
		p.setPassword(Pwd);
		p.setRegisterationNo(registerationNo);
		p.setGender(gender);
		p.setPhone(participatePhone);
		p.setAddress(address);
		
		int result = new ParticipateService().insertParticipate(p);
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "신청 성공");				
		}else {
			request.getSession().setAttribute("alertMsg", "신청 실패");
		}
		response.sendRedirect(request.getContextPath()+"/list.ma");
	}

}
