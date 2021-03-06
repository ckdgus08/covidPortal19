<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <!-- bootstrap 파일 불러오기 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <title>코로나19(covid19) 종합 포털 사이트</title>
</head>

<body>
<%
    //로그인 세션 확인
    String userId = null;

    if (session.getAttribute("user_id") != null)
    {
        userId = (String) session.getAttribute("user_id");
    }

%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp">Logo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="googleMap.jsp">map</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="detail">detail</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="bbs">게시판</a>
            </li>
            <%
                if (userId == null)
                {
            %>
            <li class="nav-item">
                <a class="nav-link" href="/member/login">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/member/join">회원가입</a>
                    <%
            } else
            {
            %>
            <li class="nav-item">
                <a class="nav-link" href="/member/logoutAction.jsp">로그아웃</a>
                    <%}%>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div>
    <img
            src="resources/static/image/main.jpeg"
            style="display: block; margin: auto; width:1280px; height:720px;"
    />
</div>
</body>

<footer>
    <jsp:include page="inner/footer.jsp"/>
</footer>

</html>