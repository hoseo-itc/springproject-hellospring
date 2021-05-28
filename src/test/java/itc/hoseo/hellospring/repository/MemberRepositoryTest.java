package itc.hoseo.hellospring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import itc.hoseo.hellospring.domain.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository repo;
	
	@Test
	@Order(2)
	public void test() {
		assertEquals(4, repo.findAll().size());
	}
	
	@Test
	@Order(1)
	public void testSave() {
		assertEquals("테수트",
				repo.save(new Member("t", "테수트", "1234")).getName());
	}
}

