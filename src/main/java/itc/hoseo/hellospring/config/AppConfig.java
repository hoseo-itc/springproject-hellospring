package itc.hoseo.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import itc.hoseo.hellospring.repository.LoginLogRepository;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapLoginLogRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;
import itc.hoseo.hellospring.service.LoginService;

@Configuration
public class AppConfig {

	@Bean
	public MemberRepository memberRepository() {
		return new HashMapMemberRepository();
	}
}
