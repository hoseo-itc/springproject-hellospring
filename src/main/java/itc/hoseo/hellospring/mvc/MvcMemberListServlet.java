package itc.hoseo.hellospring.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.MemberRepository;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/mvc/members")
public class MvcMemberListServlet extends HttpServlet{
	private final MemberRepository memberRepository = HashMapMemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO :: 코딩해보세요
	}
}
