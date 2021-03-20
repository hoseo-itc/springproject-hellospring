package itc.hoseo.hellospring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

@Component
public class MemberService {
	String name;
	
	
	public void login(Member m) {
		name = m.getName();
	}
	
	public String loginedUserName() {
		return name;
	}
	
	@Autowired
	private MemberRepository repo;
	
	public MemberService(MemberRepository repo) {
		this.repo = repo;
	}
	
	public List<Member> findByName(String name){
		return repo.findAll()
			.stream()
			.filter(m -> m.getName().contains(name))
			.collect(Collectors.toList());
	}
	
	
}
