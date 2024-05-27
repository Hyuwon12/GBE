package com.kh.feed.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.feed.model.service.FeedService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class mailageController
 */
@WebServlet("/sign.fe")
public class mailageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		
		
		int result = new MemberService().mileagePlus(mileage,userId);  
		
		
		HttpSession session = request.getSession();
		if(result>0) {
			session.setAttribute("alertMsg", "마일리지 추가");
			Member updateMem = new MemberService().loginMember(userId, userPwd);
			session.setAttribute("loginUser", updateMem);
			response.sendRedirect(request.getContextPath());
		}else {
			session.setAttribute("alertMsg", "마일리지 추가 실패");
			
		}
	}
		
		
		
		
}


