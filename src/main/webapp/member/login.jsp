<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- link -->
    <link rel="stylesheet" href="../resources/static/css/style_join.css">
    <link rel="stylesheet" href="../resources/static/css/style_login.css">
    <title> 로그인 </title></head>
<body>
<header>
    <div class="header_container">
        <div class="logo_container"><a href="../index">메인으로</a></div>
        <div class="nav_container" id="nav_menu">
            <div class="login_container">
                <ul class="login">
                    <li class="menu_login"><a class="menu_title" href="join">회원가입 하러가기</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
<div class="login_containers"><h2> 로그인 </h2>
    <form method="post" action="loginAction"><h3>아이디</h3>
        <div class="loginID"><label>
            <input type="text" class="input" placeholder="아이디" name="user_id" maxlength="20">
        </label></div>
        <h3>비밀번호</h3>
        <div class="loginPassword"><label>
            <input type="password" class="input" placeholder="비밀번호" name="user_password" maxlength="20">
        </label></div>
        <input type="submit" class="bt_login" value="로그인">
        <button type="button" onclick="location.href='/member/join' " class="bt_go_to_join">회원가입</button>
    </form>
</div>
</body>
</html>
