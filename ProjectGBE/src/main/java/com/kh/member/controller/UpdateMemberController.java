package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberController
 */
@WebServlet("/update.me")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String shose = request.getParameter("shoes");
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		Member m = new Member(userId, name, gender, address, shose, weight);
		
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "정보수정이 성공적으로 완료했습니다.");
			session.setAttribute("loginUser", updateMem);
			
			response.sendRedirect(request.getContextPath()+"/mypage.me");
		}else {
			request.setAttribute("alertMsg", "정보수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
		}
		
	}

}
