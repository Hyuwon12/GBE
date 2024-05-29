package com.kh.marathon.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.marathon.model.service.MarathonService;
import com.kh.marathon.model.service.ParticipateService;
import com.kh.marathon.model.vo.Marathon;
import com.kh.marathon.model.vo.Participate;

@Controller
public class MarathonController {
	@Autowired
	private MarathonService marathonService;
	@Autowired
	private ParticipateService participateService;
	
	@RequestMapping("list.ma")
	public String marathonList(Marathon m,HttpSession session,Model model) {
		ArrayList<Marathon> marathonArr = marathonService.selectMarathon();
		model.addAttribute("marathonArr",marathonArr);
	return "marathon/marathonMain";	
	}
	
	@RequestMapping("insert.ma")
	public String insertMarathon(Marathon m,HttpSession session,Model model) {
		int result = marathonService.deleteAllMarathon();
		if(result>0) {
			result = marathonService.insertMarathon();
			if(result>0) {
				session.setAttribute("alertMsg", "데이터베이스 초기화 완료");
				return "redirect:/";
			}
		}
		session.setAttribute("alertMsg", "데이터베이스 초기화 실패");
		return "redirect:/";
	}
	
	@RequestMapping("delete.ma")
	public String deleteMarathon(int marathonNo,HttpSession session) {
		int result = marathonService.deleteMarathon(marathonNo);
		if(result>0) {
			session.setAttribute("alertMsg", "삭제 성공");				
		}else {
			session.setAttribute("alertMsg", "삭제 실패");
		}
		return "redirect:/";
	}
	
	@RequestMapping("detail.ma")
	public String marathonDetail(int marathonNo,HttpSession session,Model model) {
		Marathon mar = marathonService.marathonDetail(marathonNo);
		ArrayList<Participate> participateList = participateService.listParticipate(marathonNo);
		model.addAttribute("participateList", participateList);
		model.addAttribute("mar", mar);
		return "marathon/marathonDetailView";
	}
	@GetMapping("restore.ma")
	public String selectDeleteMarathon(Model model){
		ArrayList<Marathon> marathonArr = marathonService.selectDeleteMarathon();
		model.addAttribute("marathonArr", marathonArr);
		return "marathon/marathonRestoreView";
	}
	
	@PostMapping("restore.ma")
	public String restoreMarathon(int marathonNo,HttpSession session) {
		int result = marathonService.restoreMarathon(marathonNo);
		if(result>0) {
			session.setAttribute("alertMsg", "복구 성공");				
		}else {
			session.setAttribute("alertMsg", "복구 실패");
		}
		return "redirect:/list.ma";
	}
	
	@GetMapping("update.ma")
	public String updateMarathonView(int marathonNo,Model model) {
		Marathon mar = marathonService.marathonDetail(marathonNo);
		model.addAttribute("mar", mar);
		return "marathon/updateMarathonView";
	}
	
	@PostMapping("update.ma")
	public String updateMarathon(Marathon m,HttpSession session) {
		int result = marathonService.updateMarathon(m);
		if(result>0) {
			session.setAttribute("alertMsg", "변경 성공");				
		}else {
			session.setAttribute("alertMsg", "변경 실패");
		}
	return "redirect:/detail.ma?marathonNo="+m.getMarathonNo();
	}
	
	@RequestMapping("search.ma")
	public String searchMarathon(String searchName,Model model) {		
		ArrayList<Marathon> searchArr = marathonService.searchMarathon(searchName);
		int contentCount= 0;
		if(searchArr!=null) {
			contentCount=searchArr.size();
		}
		model.addAttribute("marathonArr", searchArr);
		model.addAttribute("contentCount", contentCount);
		model.addAttribute("searchName", searchName);
		return "marathon/searchMarathon";
	}
	@RequestMapping("")
	public String selectMarathonRegionName(int marathonNo) {
		marathonService.selectMarathonRegionName(marathonNo);
		return ""; 
	}
}
