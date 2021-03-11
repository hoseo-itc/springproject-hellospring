package itc.hoseo.hellospring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.DriverManagerMemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

public class MemberRepositoryTest {

	private MemberRepository repository = DriverManagerMemberRepository.getInstance();
	
	@AfterEach
	public void clearRepository() {
		repository.clear();
	}
	
	@Test
	public void findAll(){
		//given
		Member m1 = new Member("학생1", 10);
		Member m2 = new Member("학생2", 10);
		
		//when
		repository.save(m1);
		repository.save(m2);
		List<Member> list = repository.findAll();
		
		//then
		assertThat(list.size()).isEqualTo(2);
		assertThat(list).contains(m1, m2);
	}
	
	@Test
	public void findById(){
		//given
		Member m1 = new Member("학생1", 10);
		repository.save(m1);
		
		//when
		Member findMember = repository.findById(m1.getId());
		
		//then
		assertThat(m1.getName()).isEqualTo(findMember.getName());
		
	}
	



}
