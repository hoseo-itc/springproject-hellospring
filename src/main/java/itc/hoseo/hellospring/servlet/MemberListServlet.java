package itc.hoseo.hellospring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name="MemberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet{

	private final MemberRepository memberRepository = HashMapMemberRepository.getInstance();
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO :: Get,Post 모두 회원 목록 조회
	}
}
