package itc.hoseo.hellospring.domain;

import java.time.LocalDateTime;

import lombok.Getter;


@Getter
public class LoginLog {
	private Member member;
	private LocalDateTime loginDttm;
	private boolean loginStatus;

	public LoginLog(Member member, boolean status) {
		this.member = member;
		this.loginDttm = LocalDateTime.now();
		this.loginStatus = status;
	}
}
