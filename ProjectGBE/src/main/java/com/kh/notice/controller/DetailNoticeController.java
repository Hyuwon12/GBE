package com.kh.notice.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Attachment;
import com.kh.notice.model.vo.Notice;



/**
 * Servlet implementation class DetailNoticeController
 */
@WebServlet("/detail.no")
public class DetailNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailNoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nno = Integer.parseInt(request.getParameter("nno"));
		int result = new NoticeService().increaseCount(nno);
		
		 
		 if (result>0) {
				Notice n = new NoticeService().selectNotice(nno);
				Attachment at = new NoticeService().selectAttachment(nno);
				int[] NextNotice = new NoticeService().getPrevAndNextNoticeId(nno);
				
				request.setAttribute("notice", n);
				request.setAttribute("attachment", at);
				request.setAttribute("NoticeNext",NextNotice);
		
				request.getRequestDispatcher("views/notice/noticeDetailView.jsp").forward(request, response);
				
			}else {
				request.getSession().setAttribute("alertMsg", "조회 실패");
				response.sendRedirect(request.getHeader("referer"));
			}   
	      
	       
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
