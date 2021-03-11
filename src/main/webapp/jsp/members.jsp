<%@ page import="itc.hoseo.hellospring.repository.impl.HashMapMemberRepository"%>
<%@ page import="itc.hoseo.hellospring.domain.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	HashMapMemberRepository repository = HashMapMemberRepository.getInstance();

	List<Member> list = repository.findAll();
%><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello Spring - Join</title>
</head>
<body>
	<%
		if(list.size() > 0){	
			for(Member m : repository.findAll()){
	%>
				<p>id : <%=m.getId() %> , name : <%= m.getName() %>, age : <%= m.getAge() %></p>
	<%
			}
		} else {
	%>
		<h1><a href="/jsp/member-form.jsp">회원가입을 해주세요!</a></h1>
	<% } %>
</body>
</html>