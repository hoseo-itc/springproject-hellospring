package itc.hoseo.hellospring.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import itc.hoseo.hellospring.domain.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String login(@Valid LoginDTO loginDTO,
						BindingResult bindingResult,
						ModelMap mm,
						HttpSession session) {

		if(bindingResult.hasErrors()){
			mm.put("memberList", memberService.findAll());
			return "member/list";
		}


		if(memberService.login(loginDTO.getId(), loginDTO.getPassword()) == false) {
			return "redirect:https://http.cat/400";
		}
		session.setAttribute("loginMember", memberService.findById(loginDTO.getId()));
		return "redirect:/list";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(Member m) {
		memberService.join(m, null);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(ModelMap mm) {
		mm.put("memberList", memberService.findAll());
		mm.put("loginDTO", new LoginDTO());
		return "member/list";
	}
	
	
}
