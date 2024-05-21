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
 * Servlet implementation class InsertMemberController
 */
@WebServlet("/insert.me")
public class InsertMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/member/enrollForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//아이디, 이름, 비밀번호, 생년월일, 주소, 몸무게, 러닝화, 성별
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userPno1 = request.getParameter("userPno1");
		String userPno2 = request.getParameter("userPno2");
		String address1 = request.getParameter("address");
		String address_dt = request.getParameter("address_dt");
		double weight = Double.parseDouble(request.getParameter("weight"));
		String shoes = request.getParameter("shoes");
		String gender = request.getParameter("gender");
		
		String userPno = userPno1+"-"+userPno2;
		String address = address1+" "+address_dt;
		
		Member m = new Member(userName,userId,userPwd,gender,address,userPno,shoes,weight);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath());
		}else {
			
			request.setAttribute("alertMsg", "회원가입 실패");
			request.getRequestDispatcher("views/member/enrollForm.jsp").forward(request, response);;
		}
		
	}

}
