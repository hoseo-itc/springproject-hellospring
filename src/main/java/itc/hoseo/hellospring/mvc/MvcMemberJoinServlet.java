package itc.hoseo.hellospring.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name="mvcMemberJoinServlet", urlPatterns = "/mvc/member-join")
public class MvcMemberJoinServlet extends HttpServlet{

	private final HashMapMemberRepository memberRepository = HashMapMemberRepository.getInstance();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String viewPath = "/WEB-INF/jsp/mvc-member-form.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		memberRepository.save(new Member(req.getParameter("name"), Integer.parseInt(req.getParameter("age"))));
		resp.sendRedirect("/mvc/members");
	}
}
