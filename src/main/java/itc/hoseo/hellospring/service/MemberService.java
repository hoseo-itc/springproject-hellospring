package itc.hoseo.hellospring.service;

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

	@Transactional
	public void join(Member member, Interest... interests ) {
		if(log.isDebugEnabled()) {
			log.debug("저장맴버 : {}", member.toString());
		}

		memberRepository.save(member);
		
		if(interests.length == 0) {
			throw new RuntimeException("한개 이상의 관심분야를 입력하여주세요");
		}
		for(Interest i : interests) {
			interestRepository.save(i); 
		}
	}
	
	public int countMembers() {
		return memberRepository.findAll().size();
	}
}
