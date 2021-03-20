package itc.hoseo.hellospring.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

@Component
public class HashMapMemberRepository implements MemberRepository {

	private static HashMapMemberRepository instance = new HashMapMemberRepository();
	
	private HashMapMemberRepository() {}
	
	public static HashMapMemberRepository getInstance() {
		return instance;
	}
	
	private Map<Integer, Member> memberMap = new ConcurrentHashMap<>();
	
	public Member save(Member member) {
		final int id = member.getId() == null ? memberMap.size() + 1 : member.getId();
		member.setId(id);
		memberMap.put(id, member);
		
		return member;
	}
	
	
	public List<Member> findAll(){
		return memberMap.values().stream().collect(Collectors.toList());
	}
	
	public Member findById(Integer id){
		return memberMap.get(id); 
	}
	
	/**
	 * 회원 저장소 초기화
	 */
	public void clear() {
		//add comment
		memberMap.clear();
	}
	
}
