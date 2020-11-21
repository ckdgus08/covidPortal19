<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp">Logo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="googleMap.jsp">map</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="detail.jsp">detail</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<h2>로그인</h2>
<form action="login" method="post">
    아아디 : <input type="text" name="userId"><br>
    비밀번호 : <input type="password" name="password"><br>
    <input type="submit" value="로그인">
    <input type='button' value='취소' onClick='location.href="<%=request.getContextPath()%>/student/list"'>
</form>
</body>
</html>
