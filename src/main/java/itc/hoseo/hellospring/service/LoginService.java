package itc.hoseo.hellospring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import itc.hoseo.hellospring.domain.LoginLog;
import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.LoginLogRepository;
import itc.hoseo.hellospring.repository.MemberRepository;

@Service
public class LoginService {
	private LoginLogRepository loginLogRepository;
	private MemberRepository memberRepository;
	
	public LoginService(LoginLogRepository loginLogRepository, MemberRepository memberRepository) {
		this.loginLogRepository = loginLogRepository;
		this.memberRepository = memberRepository;
	}

	public boolean login(String id, String password) {
		//1. 사용자가 있는지 없는지 확인해서 없으면 에러 리턴
		Member findMember  = memberRepository.findById(id);
		if(findMember == null) {
			throw new IllegalArgumentException("사용자가 존재하지 않습니다.");
		}
		
		//2. 만약에 사용자가 있으면 로그인 로그 5개를 끊어와서 로그값이 전부 로그인 실패면
		//예외를 발생
		List<LoginLog> logs = new ArrayList<LoginLog>(loginLogRepository.getLoginLogs(id));
		if(logs.size() >= 5) {
			Collections.reverse(logs);
			boolean isLocked = logs.stream().limit(5).allMatch(l -> l.isLoginStatus() == false);
			if(isLocked) {
				throw new RuntimeException("계정이 잠겼습니다.");
			}
		}
		//3. 가져온 사용자 정보와 입력받은 ID,PW가 일치하면 true / 불일치면 false
		//뭐가됬든 로그를 남김
		boolean isMatched = findMember.getPassword().equals(password);
		loginLogRepository.addLog(new LoginLog(findMember, isMatched));
		return isMatched;
		
	}
	
}
