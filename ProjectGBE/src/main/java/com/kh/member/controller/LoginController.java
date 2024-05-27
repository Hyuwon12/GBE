package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/member/loginForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Cookie cookie = null;
		String saveId = request.getParameter("saveId");
		
		if(saveId != null) {
			cookie = new Cookie("userId",userId);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
		}else {
			cookie = new Cookie("userId",null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		
		Member loginUser = new MemberService().loginMember(userId,userPwd);
		
		HttpSession session = request.getSession();
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", userId+"님 환영합니다.");
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("alertMsg", "로그인 실패");
			//로그인 실패시 다시 로그인 화면으로
			request.getRequestDispatcher("views/member/loginFailForm.jsp").forward(request, response);
			
		}
		
	}

}
