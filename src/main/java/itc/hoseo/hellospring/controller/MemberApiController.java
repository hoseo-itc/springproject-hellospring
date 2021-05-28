package itc.hoseo.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.service.MemberService;

//@RestController
public class MemberApiController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/list")
	public List<Member> list(){
		return service.findAll();
	}
	
}
