<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login</h1>
<!-- action 을 아무 것도 주지 않으면 현재 경로 http://localhost:9090/sample/login -->
<form action="" method="post">
	<div>
		<%-- 이름을 지정하지 않았을 때
		<input type="text" name="num1" id="num1" size="5" value="${numDTO.num1}"/> +
		<input type="text" name="num2" id="num2" size="5" value="${numDTO.num2}"/> =
		 --%>
		 
		<input type="text" name="num1" id="num1" size="5" value="${dto.num1}"/> +
		<input type="text" name="num2" id="num2" size="5" value="${dto.num2}"/> =
		<input type="text" name="result" id="result" size="5" value="${result}" /> 
		<button type="submit">전송</button>
	</div>
</form>
<div>
	<%-- 모든 요청은 컨트롤러로 가야함 --%>
	<p><a href="/">home</a></p>
	<p><a href="/sample/doA">doA</a></p>
	<p><a href="/sample/basic">basic</a></p>
	<p><a href="/sample/insert">insert</a></p>
</div>
</body>
</html>