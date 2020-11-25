<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.covidPotar19.Member.MemberDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %> <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>코로나19(covid19) 종합 포털 사이트</title></head>
<body><% String user_id = request.getParameter("user_id");
    String user_password = request.getParameter("user_password");
    MemberDAO memberDAO = new MemberDAO();
    int result = memberDAO.login(user_id, user_password);
    if (result == 1) // login success
    {
        session.setAttribute("user_id", user_id);
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('로그인 성공! 환영합니다')");
        script.println("location.href = '../index'");
        script.println("</script>");
    } else if (result == 0) // wrong password
    {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('비밀번호가 틀렸습니다.')");
        script.println("history.back()");
        script.println("</script>");
    } else if (result == -2) // wrong id
    {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('아이디를 확인해주세요.')");
        script.println("location.href = './login'");
        script.println("</script>");
    } else if (result == -1) // server error
    {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('서버 오류 입니다.')");
        script.println("location.href = '../index'");
        script.println("</script>");
    } %></body>
</html>
