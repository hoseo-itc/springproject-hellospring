package itc.hoseo.hellospring.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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

	MemberRepository repo = HashMapMemberRepository.getInstance();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String viewPath = "/WEB-INF/jsp/mvc-members.jsp";
		
		repo.save(new Member("맴바", 10));
		
		//req -> ServletRequest를 모델객체로 활용해서 members라는 변수에 우리가 가져온 회원 목록을 할당
		req.setAttribute("members", repo.findAll());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
		dispatcher.forward(req, resp);
		
	}
}
