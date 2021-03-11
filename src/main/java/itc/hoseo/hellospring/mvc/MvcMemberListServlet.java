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
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/mvc/members")
public class MvcMemberListServlet extends HttpServlet{
	private final HashMapMemberRepository memberRepository = HashMapMemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String viewPath = "/WEB-INF/jsp/mvc-members.jsp";
		
		req.setAttribute("members", memberRepository.findAll());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
}
