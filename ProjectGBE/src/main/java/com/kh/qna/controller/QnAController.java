package com.kh.qna.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.qna.model.service.QnAService;
import com.kh.qna.model.vo.Answer;
import com.kh.qna.model.vo.Question;

@Controller
public class QnAController {
	@Autowired
	private QnAService qnaService;
	
	@RequestMapping("list.qu")
	public String selectQuestion(Model model) {
		ArrayList<Question> questionArr = qnaService.selectQuestion();
		ArrayList<Answer> answerArr = qnaService.selectAllAnswer();
		model.addAttribute("questionArr",questionArr);
		model.addAttribute("answerArr",answerArr);
		return "QnA/listQuestion";
	}
	@ResponseBody
	@PostMapping(value="insert.an",produces = "application/json;charset=utf-8")
	public ArrayList<Answer> insertAnswer(Answer an,HttpSession session) {		
		int result = qnaService.insertAnswer(an);
		String alertMsg = "";
		if(result>0) {
			alertMsg = "등록 완료";
		}else {
			alertMsg = "등록 실패";
		}
		session.setAttribute("alertMsg",alertMsg);
		ArrayList<Answer> answerArr = qnaService.selectAnswer(an.getRefQno());
		return answerArr;
	}
	@GetMapping("insert.qu")
	public String insertQuestionView() {
		return "QnA/insertQuestion";
	}
	@PostMapping("insert.qu")
	public String insertQuestion(int memberNo,Question q,Model model) {
		q.setMemberNo(memberNo);
		int result = qnaService.insertQuestion(q);
		String alertMsg = "";
		if(result>0) {
			alertMsg = "작성 성공";
		}else {
			alertMsg = "작성 실패";
		}
		model.addAttribute("alertMsg", alertMsg);
		return "redirect:/list.qu";
	}
	@ResponseBody
	@GetMapping(value="list.an",produces = "application/json;charset=utf-8")
	public ArrayList<Answer> listAnswer(int questionId,Model model){
		JSONArray answerArr = qnaService.selectAnswer(questionId);
		return answerArr;
	}

	@GetMapping(value="insert.an",produces="application/json;charset=utf-8")
	public ArrayList<Answer> insertAnswer(int questionId,int memberNo,Answer an,Model model){
		an.setRefQno(questionId);
		an.setMemberNo(memberNo);
		int result = new QnAService().insertAnswer(a);
		String alertMsg = "";
		if(result>0) {
			alertMsg = "등록 완료";
		}else {
			alertMsg = "등록 실패";
		}
		model.addAttribute("alertMsg",alertMsg);
		JSONArray answerArr = new QnAService().selectAnswer(questionId);
		return answerArr;
	}
	@GetMapping(value="delete.an",produces="application/json;charset=utf-8")
	public int deleteAnswer(int answerId){
		int result = qnaService.deleteAnswer(answerId);
		int refQno = qnaService.selectRefQno(answerId);
		if(!result>0){
			return "errorPage";
		}
		return refQno;
	}
}
