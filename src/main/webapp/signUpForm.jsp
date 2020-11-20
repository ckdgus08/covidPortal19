<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>회원가입</title>
</head>
<body>

<form role="form" action="${pageContext.request.contextPath}/members/new" method="post" autocomplete="off">
	<p>
		<label for="userName">이름</label>
		<input type="text" placeholder="이름을 입력하세요" id="userName" name="name" />
	</p>
	<p>
		<label for="userId">아이디</label>
		<input type="text" placeholder="아이디를 입력하세요" id="userId" name="userId" />
	</p>
	<p>
		<label for="userPass">패스워드</label>
		<input type="password" placeholder="비밀번호를 입력하세요" id="userPass" name="password" />
	</p>
	<p>
		<button type="submit" id="submit" >가입하기</button>
	</p>
	<p>
		<a href="/">처음으로</a>
	</p>
</form>
</body>
</html>