package com.kh.springProject.member.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.springProject.member.model.service.MemberService;
import com.kh.springProject.member.model.vo.Member;
//@Component �ε� �� ����� �����ϴ�.
@Controller //ControllerŸ���� ������̼��� �ٿ��ָ� �� ��ĳ���� ���ؼ� �ڵ����� bean�������

public class MemberController {
	
	
	//���� jsp servlet ���
	//private MemberService service = new MemberServiceImpl();
	
	/*
	 * ���� ��ü ���� ���
	 * ��ü ���� ���յ��� �������� (�ҽ��ڵ��� ������ �Ͼ ��� ���� ������ �������.)
	 * ���񽺰� ���ÿ� ���� Ƚ���� ��û�� ��� �׸�ŭ ��ü�� ���� �� �� �ִ�.
	 *
	 * Spring�� DI(Dependency Injection) ���
	 * ��ü�� spring���� �����Ͽ� �������ش� (��ü���� ���յ��� ������)
	 * new ��� ���� Ű���� ���� ������ �ۼ��� �� @Autowired ��� ������̼Ǹ� �߰����ָ� �ȴ�.
	 *
	 * */
	
	@Autowired
	private MemberService memberService;
	
	//spring-security ���� �ʿ��� ��ȣȭ Ŭ���� ����
	@Autowired
	private BCryptPasswordEncoder bcrptPasswordEncoder;
	
	
	
	// login.me
	//���� servlet������ �� �����ּҸ��� ������ servlet�� �����Ͽ� ���ν��Ѿ� ������
	//spring������ DispatcherServlet�� ��� ��û������ ó���� �ϱ⶧����
	//controller���� �� �����ּҿ� �´� �޼ҵ带 �ۼ��ϸ� �ȴ�.
	
	
	/*
	 * Spring������ �Ķ���͸� ���� �޴� ����� request���� �޴� �����
	 * ������̼��� �̿��ϴ� ���, ������̼��� �����ϴ¹��
	 * Ŀ�ǵ� ��ü ������� �ۼ��� �� �ִ�.
	 *
	 * 1.HttpServletRequest�� �̿��Ͽ� �Ķ���� ���޹ޱ� (���� jsp/servlet ���)
	 * 	����ϰ��� �ϴ� �޼ҵ��� �Ű������� HttpServletRequest�� �ۼ��ϸ�
	 * 	������ �����̳ʰ� �ش� �޼ҵ带 ȣ���Ҷ� �ڵ����� �ش� ��ü�� �����Ͽ� �������ش�.
	 * */
	
	/*
	@RequestMapping("login.me")
	public String loginMember(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userPwd);
		//��ȯ�� ���ڿ� :�����ְ����ϴ� ���������� �����  WEB-INF/views/ �� .jsp ���̿� �����ϴ� ��� �Ǵ� ����������
		//ex) WEB-INF/views/board/boardListView.jsp ��� �Ѵٸ� �̶� ��ȯ�ؾ��ϴ� ���ڿ��� ?
		// 	  return "board/boardListView";
		return "main";//main�������� ������ó��
	}
	*/
	
	/*
	 * 2.@RequestParam ������̼� �̿��ϱ�
	 *	request.getParameter("Ű)�� ���� �����ߴ� ������ �������ִ� ������̼�
	 *	value�Ӽ��� ������ jsp���� �ۼ��ߴ� name�Ӽ����� �־��ָ� �ش� ���� �Ű������� �޾ƿ� �� ����
	 *	���� �Ѿ�� ���� ����ִ� ���¶�� defaultValue�Ӽ��� �̿��Ͽ� �⺻���� ��������
	 * */
	/*
	@RequestMapping("login.me")
	public String loginMember(@RequestParam(value="userId",defaultValue="aaa")String userId
							 ,@RequestParam(value="userPwd")String userPwd) {
		
		System.out.println(userId);
		System.out.println(userPwd);
		
		
		return "main";
	}
	*/
	
	/*
	 * 3. @RequestParam ������̼��� �����ϴ� ���
	 *  defaultValue�� ���� �߰� �Ӽ��� �ʿ����� �ʴٸ�
	 *  ������̼��� ������ �� �ִ�. ��, �Ű�������� view�������� name���� ��ġ���Ѿ��Ѵ�.
	 * */
	/*
	@RequestMapping("login.me")
	public String loginMember(String userId,String userPwd) {
		
		System.out.println(userId);
		System.out.println(userPwd);
		
		//���Ͱ��� �Ű������� �޾ƿͼ� ���̹�Ƽ���� �̿��Ͽ� ó���Ϸ���
		//�Ű������� �ϳ��� ������ �����ϱ� ������ �Ѱ��� ����ִ� �۾��� �߰������� �ʿ��ϴ�
		//ex)
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		//service�� ���� �� ��û~~~~
		
		return "main";
	}
	*/
	
	/*
	 * 4.Ŀ�ǵ� ��ü ���
	 * 	 �ش� �޼ҵ��� �Ű������� ��û�� ���ް��� ����� �ϴ� VOŬ����Ÿ���� �����ѵ�
	 * 	 ��û�� ���ް��� name�Ӽ����� VOŬ������ ������ϴ� �ʵ������ �ۼ��ϸ�
	 *   ������ �����̳ʰ� �ش� ��ü�� �⺻�����ڷ� ���� �� ���������� setter�޼ҵ带 �̿��Ͽ�
	 *   ��û�� ���ް��� �ʵ忡 ����ִ� ���		
	 * 	
	 *   * name�Ӽ����� ������ϴ� �ʵ���� ��ġ�ؾ��Ѵ� *
	 * */
	/*
	@RequestMapping("login.me")
	public String loginMember(Member m) {
		
		System.out.println(m);
		System.out.println(m.getUserId());
		System.out.println(m.getUserPwd());
		
		return "main";
		
	}
	*/
	
	
	/*
	 * ��û ó�� �� ���䵥���͸� ��� ������������ ������ �Ǵ� url ���û(redirect) �ϴ� ���
	 *
	 * 1. �������� �����ϴ� Model��ü�� �̿��ϴ� ���
	 * 	  �������� ������ �����ϰ��� �ϴ� �����͸� map ���� (key-value)�� ���� �� �ִ� ����
	 * 	  Model ��ü�� requestScope �̴�
	 * 	  �̶� �ش� ��ü�� ���� �޼ҵ�� addAttribute()�� ����Ѵ�.
	 * */
	/*
	@RequestMapping("login.me")
	public String loginMember(Member m
							 ,Model model
							 ,HttpSession session) {
		
		//m�� �����͸� ��ƿµ� service-dao-db �۾��� ��ġ�� ���ƿͼ� ���ް��� ������
		//������ ���� request.setAttribute�޼ҵ带 �̿��ϴ°��� �ƴ�
		//model�̶�� �ϴ� ��ü�� ��Ƽ� ó���Ѵ�.
		//�Ű������� Model ��ü�� �������ָ� �����������̳ʰ� �����Ͽ� �������ش�.
		//���� Session�ʿ��ϸ� ���Ͱ��� �Ű������� �����Ͽ� �޾ƿ´�
		
		//MemberService service = new MemberServiceImpl();
		//service.loginMember(m);
		//�� �۾��� ������ ����� Member loginUser �� ���ƿ�����
		
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) { //�α��� ����
			//������������ ������ - model
			model.addAttribute("errorMsg","�α��� ����");
			
			// /WEB-INF/views/ �� .jsp ������ ��θ� �ۼ�
			return "common/errorPage";
			
		}else {//�α��� ����
			//������������ redirect(���û) - session
			
			//�α��� ���� ���ǿ� ����ֱ�
			session.setAttribute("loginUser", loginUser);
			//�޼��� ���
			session.setAttribute("alertMsg", "�α��� ����!");
			
			//���û ��� (redirect���)
			// "redirect:���"
			return "redirect:/";
		}
	}
	*/
	
	/*
	 * 2.���������� �����ϴ� ModelAndView ��ü �̿��Ͽ� �����ϴ� ���
	 * 	 Model�� �����͸� key-value��Ʈ�� ���� �� �ִ� �����̶�� �Ѵٸ�
	 * 	 View�� ����信 ���� ������ ���� �� �ִ� �����̴�.
	 * 	 �� ��쿡�� ��ȯŸ���� String�� �ƴ� ModelAndView Ÿ���� �Ǿ���Ѵ�.
	 *
	 * 	 Model�� View�� ���յ� ���·� View��ü�� �ܵ����� ����Ҽ��� ����
	 * */
	/*
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m
							 ,ModelAndView mv
							 ,HttpSession session) {
		
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) { //�α��� ����
			//ModelAndView ��ü�� �����͸� ��� �޼ҵ�� addObject() �޼ҵ带 ����Ѵ�.
			mv.addObject("errorMsg", "�α��� ����!!");
			//view�������� ���� ������ ����ش� �̶� ����ϴ� �޼ҵ�� setViewName() �޼ҵ带 ����Ѵ�.
			mv.setViewName("common/errorPage"); //����ۼ������ ������ó���� ����
		}else {//�α��� ����
			session.setAttribute("alertMsg", "�α��� ����!!");
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/"); //redirect ��� �ۼ���ĵ� �����ϴ�
		}
		
		return mv; //�����Ϳ� �������������� ��Ƽ� ��ȯ�Ѵ�
		
	}*/
	//��ȣȭ ���� �α���ó��
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m
							 ,ModelAndView mv
							 ,HttpSession session) {
		//����ڰ� �Է��� ���̵� ���� �ش� ȸ���� �����ϴ��� ���� �Ǻ��� ȸ������ ��ȸ
		//��ȸ�ؿ� �������� ��й�ȣ�� �ִ� ��ȣ���� ��ȣȭ �� �����Ͱ� ����ڰ� �Է��� �򹮰� �����ϴٸ�,
		//�α��� ó��
		//��ȣȭ�����Ͱ� �򹮰� ��ġ���� ������� �α��� ����
		//�̶� ����ϰԵ� �޼ҵ� bcryptPasswordEncoder.matches(��,��ȣ��)
		
		Member loginUser = memberService.loginMember(m);
		if(loginUser == null || !bcrptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) {
			//ModelAndView ��ü�� �����͸� ��� �޼ҵ�� addObject() �޼ҵ带 ����Ѵ�.
			mv.addObject("errorMsg", "�α��� ����!!");
			//view�������� ���� ������ ����ش� �̶� ����ϴ� �޼ҵ�� setViewName() �޼ҵ带 ����Ѵ�.
			mv.setViewName("common/errorPage"); //����ۼ������ ������ó���� ����
		}else {//�α��� ����
			session.setAttribute("alertMsg", "�α��� ����!!");
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/"); //redirect ��� �ۼ���ĵ� �����ϴ�			
		}		
		return mv; //�����Ϳ� �������������� ��Ƽ� ��ȯ�Ѵ�
		
	}
	//�α׾ƿ� �޼ҵ�
	@RequestMapping("logout.me")
	public String logoutMember(HttpSession session) {
		
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
	//ȸ������ �������� �̵� �޼ҵ�
	@GetMapping("insert.me")
	public String memberEnrollForm() {

		return "member/memberEnrollForm";
	}
	
	//ȸ������ ��� �޼ҵ�
	@PostMapping("insert.me")
	public String insetMember(Member m,HttpSession session,Model model) {
		
		//��ȣȭ ��������� Member m�� �״�� ��������
		//��ȣȭ�۾� �߰��ϸ� Member m�� ����ִ� password�� �����ؼ� ��ȣȭ ó����
		//�ٽ� �����Ͽ� �����Ѵ�.
		//��ȣȭ �۾��ϱ�
		//bcryptPasswordEncoder�� �޼ҵ��� encode() ����ϱ�
		String encPwd = bcrptPasswordEncoder.encode(m.getUserPwd());
		m.setUserPwd(encPwd);
		int result = memberService.insertMember(m);
		
		//��й�ȣ�� ����ڰ� �Է��� �״�� �����ͺ��̽��� ����Ǵ� ��Ȳ
		//��й�ȣ�� ��ȣȭ�Ͽ� �����ϱ�
		//��й�ȣ ��ȣȭ �۾� ��� Bcrpt ������� ����
		//1)spring-security Dependency���� �����ϴ� ����� ����Ұ�
		
		
		//�����ϸ� ȸ������ ����! �޼����� �Բ� ������������ �̵�
		if(result>0) {
			session.setAttribute("alertMsg", "ȸ�����Լ���");
			return "redirect:/";
		//�����ϸ� ȸ������ ���и޼����� �Բ� ������������ �̵�
		}else {
			model.addAttribute("alertMsg", "ȸ������ ����");
			return "common/errorPage";
		
		}
			
		}
	@RequestMapping("mypage.me")
	public String myPage() {
		
		return "member/myPage";
	}
	@PostMapping("update.me")
	public String updateMember(Member m,HttpSession session,Model model) {
		int result = memberService.updateMember(m);
		if(result>0) {
			Member loginUser = memberService.loginMember(m);
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "�������� ����!");			
			return "redirect:myPage";
		//�����ϸ� ȸ������ ���и޼����� �Բ� ������������ �̵�
		}else {
			model.addAttribute("alertMsg", "�������� ����!");
			return "common/errorPage";		
		}
	}
	@PostMapping("delete.me")
	public String deleteMember(String userPwd,HttpSession session,Model model) {
		Member m = ((Member)session.getAttribute("loginUser"));
		String encPwd = m.getUserPwd();
		if(bcrptPasswordEncoder.matches(userPwd, encPwd)) {
			int result = memberService.deleteMember(m);
			if(result>0) {				
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg", "���������� Ż�� �Ǿ����ϴ�.");
				return "redirect:/";
			} else {
				model.addAttribute("alertMsg", "ȸ�� Ż�� ����!");
				return "common/errorPage";
			}			
		} else {
			session.setAttribute("alertMsg", "��й�ȣ �Է� ����");
			return "member/myPage";
		}
		
	}
}