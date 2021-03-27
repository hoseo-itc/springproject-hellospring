package itc.hoseo.hellospring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.LoginLogRepository;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapLoginLogRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;
import itc.hoseo.hellospring.service.LoginService;



@SpringBootTest
class BootLoginServiceTest implements ApplicationContextAware{
	
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	
	@Test
	void test() {
		
		MemberRepository memberRepo = context.getBean(MemberRepository.class);
		LoginService loginService = context.getBean(LoginService.class);
		
		memberRepo.save(new Member("test","1234"));
		
		//assertEquals(true, loginService.login("testMember", "0000"));
		
		//비밀번호 4회 틀리고 5번째 맞음(계정 안잠김)
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(true, loginService.login("test", "1234"));
		
		//비밀번호 5번 틀리고 6번째 맞음(계정 잠김)
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertEquals(false, loginService.login("test", "false"));
		assertThrows(RuntimeException.class,() ->{
			assertEquals(true, loginService.login("test", "1234"));
		});
	}

	

}
