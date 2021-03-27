package itc.hoseo.hellospring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import itc.hoseo.hellospring.config.AppConfig;
import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.LoginLogRepository;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapLoginLogRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;
import itc.hoseo.hellospring.service.LoginService;

class JavaScopeLoginServiceTest {

	@Test
	void test() {
		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig.class);

		MemberRepository mr1 = ctx1.getBean(MemberRepository.class);
		MemberRepository mr2 = ctx1.getBean(MemberRepository.class);
		
		assertEquals(mr1, mr2);
		
	}

}
