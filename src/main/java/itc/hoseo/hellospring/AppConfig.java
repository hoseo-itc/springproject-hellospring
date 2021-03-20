package itc.hoseo.hellospring;

import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.DriverManagerMemberRepository;
import itc.hoseo.hellospring.service.MemberService;

public class AppConfig {

	public static MemberRepository getMemberRepository() {
		return DriverManagerMemberRepository.getInstance();
	}
	

	public static MemberService getMemberService() {
		return new MemberService(getMemberRepository());
	}

}
