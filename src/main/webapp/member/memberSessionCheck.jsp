<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userId = (String) session.getAttribute("user_id");
    if (userId == null)
    {
%>
<script>
    alert("이용하기 위해 로그인이 필요합니다.");
    location.href = "/member/login";
</script>
<%
    }
%>