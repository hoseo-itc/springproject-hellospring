package itc.hoseo.hellospring.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

public class HashMapMemberRepository implements MemberRepository {

	private static HashMapMemberRepository instance = new HashMapMemberRepository();
	
	private HashMapMemberRepository() {}
	
	public static HashMapMemberRepository getInstance() {
		return instance;
	}
	
	private Map<Integer, Member> memberMap = new ConcurrentHashMap<>();
	
	public Member save(Member member) {
		//TODO :: 기존 회원의 ID를 가지고 있다면 Update, 없으면 +1씩 증가하며 ID를 부여하며 저장
		//throw new IllegalStateException("아직 구현되지 않은 기능입니다.");
		
		final int id = member.getId() == null ? memberMap.size() + 1 : member.getId();
		member.setId(id);
		memberMap.put(id, member);
		
		return member;
	}
	
	
	public List<Member> findAll(){
		//TODO :: 회원 조회 기능
		//throw new IllegalStateException("아직 구현되지 않은 기능입니다.");
		return memberMap.values().stream().collect(Collectors.toList());
	}
	
	public Member findById(Integer id){
		//TODO :: 특정 ID로 회원 찾기
		//throw new IllegalStateException("아직 구현되지 않은 기능입니다.");
		return memberMap.get(id); 
	}
	
	/**
	 * 회원 저장소 초기화
	 */
	public void clear() {
		memberMap.clear();
	}
	
}
