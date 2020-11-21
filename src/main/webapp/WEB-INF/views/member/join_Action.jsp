<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.covidPotar19.Member.MemberDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %> <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title> 회원가입 </title></head>
<body><% String user_id = request.getParameter("user_id");
    String user_password = request.getParameter("user_password");
    String user_name = request.getParameter("user_name");
    // -1: 서버 오류 / 0: 이미존재하는 아이디 / 1: 성공
    if (user_id == null || user_password == null || user_name == null)
    {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('빈칸을 확인해 주세요')");
        script.println("history.back()");
        script.println("</script>");
    } else
    {
        MemberDAO memberDAO = new MemberDAO();
        memberDAO.setUser_id(user_id);
        memberDAO.setUser_password(user_password);
        memberDAO.setUser_name(user_name);
        int result = memberDAO.join(memberDAO);
        if (result == -1)
        {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('서버오류')");
            script.println("history.back()");
            script.println("</script>");
        } else if (result == 0)
        {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('이미 아이디가 존재합니다.')");
            script.println("history.back()");
            script.println("</script>");
        } else
        {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('회원가입을 축하드립니다.')");
            script.println("location.href = '../index'");
            script.println("</script>");
        }
    } %></body>
</html>
