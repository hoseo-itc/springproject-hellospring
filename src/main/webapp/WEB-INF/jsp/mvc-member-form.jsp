<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello Spring - Join</title>
</head>
<body>
	<form action="/mvc/member-join" method="post">
		<p>이름 : <input type="text" name="name" id="name" /></p>
		<p>나이 : <input type="text" name="age" id="age" /></p> 
		<button type="submit">가입</button>
	</form>
</body>
</html>