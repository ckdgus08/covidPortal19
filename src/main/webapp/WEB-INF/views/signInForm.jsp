<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form action="login" method="post">
    학번: <input type="text" name="student_no"><br>
    비밀번호: <input type="password" name="password"><br>
    <input type="submit" value="로그인">
    <input type='button' value='취소' onClick='location.href="<%=request.getContextPath()%>/student/list"'>
</form>
</body>
</html>
