<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>회원가입</title>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- link -->
    <link rel="stylesheet" href="../resources/static/css/style_join.css">
    <link rel="stylesheet" href="../resources/static/css/style_login.css">

</head>
<body>

<header>
    <div class="header_container">
        <div class="logo_container"><a href="../index">메인으로</a></div>
        <div class="nav_container" id="nav_menu">
            <div class="login_container">
                <ul class="login">
                    <li class="menu_login"><a class="menu_title" href="login">로그인하러 가기</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
<div class="join_container"><h2>회원가입</h2>
    <form method="post" action="join_Action">
        <h3>아이디</h3>
        <div class="joinID"><input type="text" class="input" style="ime-mode:disabled;" placeholder="아이디" name="user_id"
                                   title="아이디" maxlength="20"></div>
        <h3>비밀번호</h3>
        <div class="joinPassword"><input type="password" class="input" placeholder="비밀번호" name="user_password"
                                         title="비밀번호" maxlength="20"></div>
        <h3>이름</h3>
        <div class="joinName"><input type="text" class="input" placeholder="이름" name="user_name" title="이름"
                                     maxlength="20"></div>
        <input type="submit" class="bt_join" value="가입하기"></form>
</div>
</body>
</html>