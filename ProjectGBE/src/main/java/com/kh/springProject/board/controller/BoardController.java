package com.kh.springProject.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springProject.board.model.service.BoardService;
import com.kh.springProject.board.model.vo.Board;
import com.kh.springProject.board.model.vo.Reply;
import com.kh.springProject.common.model.vo.PageInfo;
import com.kh.springProject.common.template.PageNation;
@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("list.bo")
	public String boardList(int currentPage,Model model) {
		int listCount = boardService.listCount();
		int pageLimit = 10;
		int boardLimit = 5;
		PageInfo pi = PageNation.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
		ArrayList<Board> boardList = boardService.selectList(pi);
		model.addAttribute("pi", pi);
		model.addAttribute("boardList",boardList);
		return "board/boardListView";
	}
	@RequestMapping("detail.bo")
	public String selectBoard(int boardNo,HttpSession session,Model model) {
		int result = boardService.increaseCount(boardNo);
		if(result<0) {
			session.setAttribute("alertMsg", "게시글 조회 실패!");
			return "redirect:/";			
		}
		Board b = boardService.selectBoard(boardNo);
		int rcount = boardService.selectRcount(boardNo);
		ArrayList<Reply> replyList = boardService.replyList(boardNo);		
		model.addAttribute("b",b);
		model.addAttribute("rcount",rcount);
		model.addAttribute("replyList",replyList);
		return "board/boardDetailView";
	}
	@GetMapping("insert.bo")
	public String boardEnrollForm() {
		return "board/boardEnrollForm";
	}
	@PostMapping("insert.bo")
	public String InsertBoard(Board b,MultipartFile upfile,HttpSession session) {
		//첨부된 파일의 유무에 상관없이 multipartFile객체는 만들어져서 주입된다.
		//때문에 파일이 넘어왔는지 여부를 판별하는 작업을 null비교가 아닌
		//filename에 담긴 값이 빈값인지 확인하는 작업으로 처리해야한다.
		//전달된 파일이 있을 결우, 파일명 수정작업후 서버에 업로드, 원본명과 수정된 파일명을 DB에 등록
		if(!upfile.getOriginalFilename().equals("")) {
			//파일명 수정작업하기
			//1.원본파일명 추출
			String originName = upfile.getOriginalFilename();
			//2.시간형식 문자열로 만들기
			//20240527162730
			String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			//3.확장자 추출하기
			String ext = originName.substring(originName.lastIndexOf("."));
			//4.랜텀값 5자리 뽑아주기
			int ranNum = (int)(Math.random()*90000+10000);
			//5.하나로 합쳐주기
			String changeName = currentTime+ranNum+ext;
			//6.업로드하고자하는 물리적인 경로 알아내기(프로젝트내에 저장될 실제경로찾기)
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
			//7.경로와 수정파일명을 합쳐, 파일업로드 처리하기
			try {
				upfile.transferTo(new File(savePath+changeName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//board에 변경된 파일명과 원본파일명 담아주기
			b.setOriginName(originName);
			b.setChangeName("resources/uploadFiles/"+changeName);
		}
		int result = boardService.insertBoard(b);
		if(result>0) {
			session.setAttribute("alertMsg", "게시글 작성 성공");			
		}else {
			session.setAttribute("alertMsg", "게시글 작성 실패");
		}		
		return "redirect:/list.bo?currentPage=1";
	}
	
	@RequestMapping("insert.re")
	public void insertReply(Reply r,HttpSession session,Model model) {
		int result = boardService.insertReply(r);
		if(result>0) {
			
		}
	}
	@RequestMapping("select.re")
	public void selectReply(int boardNo) {
		ArrayList<Reply> replyList = boardService.replyList(boardNo);
		
	}
}
