package itc.hoseo.hellospring.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.service.MemberService;

@RestController
public class MemberRestController {

	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private MemberService service;
	
	@PostConstruct
	public void init() {
		repo.save(new Member("hello", 10));
		repo.save(new Member("hewoo", 20));
	}
	
	@GetMapping("/rest/members")
	public List<Member> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("/rest/member")
	public List<Member> findAll(@RequestParam(name = "name") String name){
		return service.findByName(name);
	}
	
}
