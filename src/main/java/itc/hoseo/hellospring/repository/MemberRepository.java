package itc.hoseo.hellospring.repository;

import java.sql.Connection;
import java.util.List;

import itc.hoseo.hellospring.domain.Member;

public interface MemberRepository {
	public Member save(Member member);
	public List<Member> findAll();
	public Member findById(String id);
	public void clear();	
}
