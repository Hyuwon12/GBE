package com.kh.marathon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.marathon.model.service.MarathonService;
import com.kh.marathon.model.service.ParticipateService;
import com.kh.marathon.model.service.RegionService;
import com.kh.marathon.model.vo.Marathon;
import com.kh.marathon.model.vo.Participate;
@Controller
public class ParticipateController {
	@Autowired
	private ParticipateService participateService;
	@Autowired
	private MarathonService marathonService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@GetMapping("insert.pa")
	public String insertParticipateView(int marathonNo,int memberNo,Model model) {
		Marathon m = marathonService.marathonDetail(marathonNo);		
		String[] courseList = m.getMarathonCourse().split(",");
		model.addAttribute("marathonName", m.getMarathonName());
		model.addAttribute("marathonNo", m.getMarathonNo());
		model.addAttribute("courseList", courseList);
		model.addAttribute("memberNo", memberNo);
		return "marathon/insertParticipateView";
	}
	@PostMapping("insert.pa")
	public String insertParticipate(Participate p,int memberNo,int marathonNo,HttpSession session) {
		p.setPassword(bcryptPasswordEncoder.encode(p.getPassword()));		
		String regionName = marathonService.selectMarathonRegionName(marathonNo);
		int regionId = regionService.selectRegionId(regionName);
		p.setRegionId(regionId);				
		int result = participateService.insertParticipate(p);
		if(result>0) {
			session.setAttribute("alertMsg", "신청 성공");				
		}else {
			session.setAttribute("alertMsg", "신청 실패");
		}
		return "redirect:/detail.ma?marathonNo="+marathonNo;
	}
}
