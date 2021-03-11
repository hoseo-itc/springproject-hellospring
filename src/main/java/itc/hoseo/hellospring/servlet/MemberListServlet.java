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
import itc.hoseo.hellospring.repository.impl.HashMapMemberRepository;

@WebServlet(name="MemberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet{

	private final HashMapMemberRepository memberRepository = HashMapMemberRepository.getInstance();
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		StringBuilder memberBuilder = new StringBuilder();
		List<Member> members = memberRepository.findAll();
		for(Member m : members) {
			memberBuilder.append(
					String.format("<p> id : %d , name : %s, age : %d </p>", 
					m.getId(), m.getName(), m.getAge()));
		}
		
		String html = String.join(
				"<!DOCTYPE html>",
				"<html>",
				"<head>",
				"<meta charset=\"utf-8\">",
				"<title>Hello Spring - Join</title>",
				"</head>",
				"<body>",
				StringUtils.hasText(memberBuilder.toString()) == false ? 
						"<h1><a href=\"/servlet/member/join\">회원가입을 해주세요.</a></h1>" : memberBuilder.toString() ,
				"</body>",
				"</html>"	
			).toString();
		
		resp.getWriter().write(html);
	}
}
