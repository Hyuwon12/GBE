package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/profile.me")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
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
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/views/member/img/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,"UTF-8",new MyFileRenamePolicy());
			
			String userId = multiRequest.getParameter("userId");
			String userPwd = multiRequest.getParameter("userPwd");
			
			Member m = null;
			
			if(multiRequest.getOriginalFileName("profile-input") != null) {
				
				m = new Member();
				m.setMemberId(userId);
				m.setProfileImage(multiRequest.getOriginalFileName("profile-input")); //원본파일명
				m.setChangeName(multiRequest.getFilesystemName("profile-input")); //서버에 업로드되어있는 파일명
				m.setFilePath("/views/member/img/");
			}
			
			
			int result = new MemberService().updateProfile(m);
			Member loginUser = new MemberService().loginMember(userId, userPwd);
			
			
			HttpSession session = request.getSession();
			
			if(result>0) {
				session.setAttribute("alertMsg", "프로필 변경 성공");
				session.removeAttribute("loginUser");
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath()+"/mypage.me");
			}else {
				System.out.println("실패");
			}
			
		}
	}

}
