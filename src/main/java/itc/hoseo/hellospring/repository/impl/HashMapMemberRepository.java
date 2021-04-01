package itc.hoseo.hellospring.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

@Repository
public class HashMapMemberRepository implements MemberRepository {

	@PostConstruct
	public void init() {
		this.save(new Member("testMember","0000"));
	}
	
	private Map<Integer, Member> memberMap = new ConcurrentHashMap<>();
	
	public Member save(Member member) {
		final int key = member.getSeq() == null ? 
				memberMap.size() + 1 : member.getSeq();
		member.setSeq(key);
		memberMap.put(key, member);
		
		return member;
	}
	
	
	public List<Member> findAll(){
		return memberMap.values().stream().collect(Collectors.toList());
	}
	
	public Member findById(String id){
		for(Member m : memberMap.values()) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 * 회원 저장소 초기화
	 */
	public void clear() {
		//add comment
		memberMap.clear();
	}


	
}
