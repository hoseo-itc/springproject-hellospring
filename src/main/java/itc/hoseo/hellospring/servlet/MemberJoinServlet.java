package itc.hoseo.hellospring.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itc.hoseo.hellospring.domain.Member;
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name="MemberJoinServlet", urlPatterns = "/servlet/member/join")
public class MemberJoinServlet extends HttpServlet{

	private final HashMapMemberRepository memberRepository = HashMapMemberRepository.getInstance();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		String html = String.join(
				"<!DOCTYPE html>",
				"<html>",
				"<head>",
				"<meta charset=\"utf-8\">",
				"<title>Hello Spring - Join</title>",
				"</head>",
				"<body>",
				"	<form action=\"/servlet/member/join\" method=\"post\">",
				"		<p>이름 : <input type=\"text\" name=\"name\" id=\"name\" /></p>",
				"		<p>나이 : <input type=\"text\" name=\"age\" id=\"age\" /></p>", 
				"		<button type=\"submit\">가입</button>",
				"	</form>",
				"</body>",
				"</html>"	
			).toString();
		resp.getWriter().write(html);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setContentType("utf-8");
		memberRepository.save(new Member(req.getParameter("name"), Integer.parseInt(req.getParameter("age"))));
		resp.sendRedirect("/servlet/members");
	}
}
