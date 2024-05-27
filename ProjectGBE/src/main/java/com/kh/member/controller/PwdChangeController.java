package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class PwdChangeController
 */
@WebServlet("/changePwd.me")
public class PwdChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdChangeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/views/member/changePwdForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().changePwd(userId,userPwd);
		
		if(result > 0) {
			HttpSession session = request.getSession();
			
			session.setAttribute("alertMsg", "비밀번호가 정상적으로 변경되었습니다.");
			session.removeAttribute("loginUser");
			
			response.sendRedirect(request.getContextPath());
		}else {
			request.setAttribute("alertMsg", "비밀번호 변경이 완료되지 않았습니다.");
			request.getRequestDispatcher("views/member/findPwdForm.jsp").forward(request, response);
		}
	}

}
