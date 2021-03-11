<%@ page import="itc.hoseo.hellospring.repository.impl.HashMapMemberRepository"%>
<%@ page import="itc.hoseo.hellospring.domain.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	HashMapMemberRepository repository = HashMapMemberRepository.getInstance();

	Member member = new Member(request.getParameter("name"), Integer.parseInt(request.getParameter("age")));
	
	repository.save(member);
	
	response.sendRedirect("/jsp/members.jsp");
%>