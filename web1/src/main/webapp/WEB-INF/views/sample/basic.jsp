<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>basic</h1>
<div>
<div>
<%--
	경로를 시작할 때 / 로 시작한다는 의미는
	http://localhost:9090/ 뒤에 주소를 붙여 나감
	
	/ 없이 시작하면 현재 주소에서 뒷부분만 변경한다는 의미
 --%>
	<p>${page}</p>
	<%-- 모든 요청은 컨트롤러로 가야함 --%>
	<p><a href="/">home</a></p>
	<p><a href="doA">doA</a></p> <%-- /sample/doA --%>
	<p><a href="login">login</a></p>
	<p><a href="insert">insert</a></p>
</div>
</div>
</body>
</html>