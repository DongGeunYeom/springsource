<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<div>
	age : <%=request.getParameter("age") %>
</div>
<div>
	num : ${num}
</div>
</div>
<div>
	<%-- 모든 요청은 컨트롤러로 가야함 --%>
	<p><a href="/sample/basic">basic</a></p>
	<p><a href="/sample/doA">doA</a></p>
	<p><a href="/sample/login">login</a></p>
	<p><a href="/sample/insert">insertsample</a></p>
	<p><a href="/board/list">List</a></p>
	<p><a href="/board/read">Read</a></p>
	<p><a href="/board/modify">ModiFy</a></p>
	<p><a href="/board/insert">Insertboard</a></p>
	<p><a href="/calc/add">Add</a></p>
	<p><a href="/member/register">Register</a></p>
	
</div>
</body>
</html>
