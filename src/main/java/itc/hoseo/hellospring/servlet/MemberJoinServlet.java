package itc.hoseo.hellospring.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name="MemberJoinServlet", urlPatterns = "/servlet/member/join")
public class MemberJoinServlet extends HttpServlet{

	private final MemberRepository memberRepository = HashMapMemberRepository.getInstance();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO :: Get 방식 처리(회원 가입 폼 전송)
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO :: Post 방식 처리(실제 회원 가입)
	}
}
