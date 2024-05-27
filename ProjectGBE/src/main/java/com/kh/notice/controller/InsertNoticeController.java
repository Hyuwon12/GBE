package com.kh.notice.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Attachment;
import com.kh.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;



/**
 * Servlet implementation class InsertNoticeController
 */
@WebServlet("/insert.no")
public class InsertNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("views/notice/noticeInsertView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		    
		   
		    boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		    if (isMultipart) {
		        // 최대 파일 크기 지정
		        int maxSize = 10 * 1024 * 1024; 
		        // 파일이 저장될 경로
		        String savePath = request.getSession().getServletContext().getRealPath("/views/notice/uploadFile/");
		        
		        MultipartRequest multiRequest = new MultipartRequest(
		            request, 
		            savePath, 
		            maxSize, 
		            "UTF-8", 
		            new MyFileRenamePolicy()
		        );
		        
		        String title = multiRequest.getParameter("title");
		        String content = multiRequest.getParameter("content");
		        
		        String memberNo = multiRequest.getParameter("memberNo");
		
		        HttpSession session = request.getSession();
		        int memberId = Integer.parseInt(memberNo);	
		  
		        Notice notice = new Notice();
		        notice.setNoticeTitle(title);
		        notice.setNoticeContent(content);
		        notice.setMemberNo(memberId);
		        
		      
		        Attachment attachment = null;
		        if (multiRequest.getOriginalFileName("uploadFile") != null) {
		            attachment = new Attachment();
		            attachment.setOriginName(multiRequest.getOriginalFileName("uploadFile"));
		            attachment.setChangeName(multiRequest.getFilesystemName("uploadFile"));
		            attachment.setFilePath("/views/notice/uploadFile/");
		        }
		        
		        int result = new NoticeService().insertNotice(notice, attachment);

		        if (result > 0) {
		            session.setAttribute("alertMsg", "게시글 작성 성공");
		            
		            response.sendRedirect(request.getContextPath() + "/list.no?currentPage=1");
		        } else {
		        	if(attachment!=null) {
						new File(savePath+attachment.getChangeName()).delete();
					}
		            session.setAttribute("alertMsg", "게시글 작성 실패");
		            response.sendRedirect(request.getContextPath() + "/list.no?currentPage=1");
		        }
		    }
		} 
		



}
