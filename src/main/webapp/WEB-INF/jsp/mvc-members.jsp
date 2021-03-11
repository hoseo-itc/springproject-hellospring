<%@ page import="itc.hoseo.hellospring.repository.impl.HashMapMemberRepository"%>
<%@ page import="itc.hoseo.hellospring.domain.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello Spring - Join</title>
</head>
<body>
	
	<c:if test="${ empty members}">
		<h1><a href="/mvc/member-join">회원가입을 해주세요!</a></h1>
	</c:if>

	<c:forEach var="member" items="${members}">
		<p> id : ${member.id} , name : ${member.name} , age : ${member.age} </p>
	</c:forEach>
</body>
</html>