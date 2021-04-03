package itc.hoseo.hellospring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import itc.hoseo.hellospring.domain.Interest;
import itc.hoseo.hellospring.repository.InterestRepository;

@SpringBootTest
public class InterestTest {

	@Autowired
	private InterestRepository interestRepository;
	
	@Test
	public void test() {
		interestRepository.save(new Interest("admin", "넷플릭스"));
		interestRepository.save(new Interest("admin", "고기먹기"));
		
		assertEquals(2, interestRepository.findById("admin").size());
		assertEquals("고기먹기", interestRepository.findById("admin").get(1).getName());
	}
	
	
}
