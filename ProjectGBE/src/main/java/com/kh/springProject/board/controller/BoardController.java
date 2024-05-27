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
			session.setAttribute("alertMsg", "�Խñ� ��ȸ ����!");
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
		//÷�ε� ������ ������ ������� multipartFile��ü�� ��������� ���Եȴ�.
		//������ ������ �Ѿ�Դ��� ���θ� �Ǻ��ϴ� �۾��� null�񱳰� �ƴ�
		//filename�� ��� ���� ������ Ȯ���ϴ� �۾����� ó���ؾ��Ѵ�.
		//���޵� ������ ���� ���, ���ϸ� �����۾��� ������ ���ε�, ������� ������ ���ϸ��� DB�� ���
		if(!upfile.getOriginalFilename().equals("")) {
			//���ϸ� �����۾��ϱ�
			//1.�������ϸ� ����
			String originName = upfile.getOriginalFilename();
			//2.�ð����� ���ڿ��� �����
			//20240527162730
			String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			//3.Ȯ���� �����ϱ�
			String ext = originName.substring(originName.lastIndexOf("."));
			//4.���Ұ� 5�ڸ� �̾��ֱ�
			int ranNum = (int)(Math.random()*90000+10000);
			//5.�ϳ��� �����ֱ�
			String changeName = currentTime+ranNum+ext;
			//6.���ε��ϰ����ϴ� �������� ��� �˾Ƴ���(������Ʈ���� ����� �������ã��)
			String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
			//7.��ο� �������ϸ��� ����, ���Ͼ��ε� ó���ϱ�
			try {
				upfile.transferTo(new File(savePath+changeName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//board�� ����� ���ϸ�� �������ϸ� ����ֱ�
			b.setOriginName(originName);
			b.setChangeName("resources/uploadFiles/"+changeName);
		}
		int result = boardService.insertBoard(b);
		if(result>0) {
			session.setAttribute("alertMsg", "�Խñ� �ۼ� ����");			
		}else {
			session.setAttribute("alertMsg", "�Խñ� �ۼ� ����");
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
