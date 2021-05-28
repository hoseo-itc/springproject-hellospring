package itc.hoseo.hellospring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import itc.hoseo.hellospring.domain.Interest;
import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.InterestRepository;
import itc.hoseo.hellospring.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

@Service

@Slf4j
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private InterestRepository interestRepository;

	
	public boolean login(String id, String password) {
		Member findMember = memberRepository.findById(id);
		if(findMember == null 
				|| findMember.getPassword().equals(password) == false) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public void join(Member member, Interest... interests ) {
		memberRepository.save(member);
	}
	
	public int countMembers() {
		return memberRepository.findAll().size();
	}
	
	public List<Member> findAll(){
		return memberRepository.findAll();
	}
	
	public Member findById(String id) {
		return memberRepository.findById(id);
	}
	
}
