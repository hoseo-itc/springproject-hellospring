package itc.hoseo.hellospring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	private MemberService service;
	
	
	@Test
	public void test() {
		
		assertThrows(RuntimeException.class, () -> {
			service.join(new Member("fail", "name","password"));
		});
		
		assertEquals(3, service.countMembers());
	}
	
	
}
