<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  errorPage="../error.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>코로나19(covid19) 종합 포털 사이트</title>
</head>
<body>
    <%
    String userId = (String)session.getAttribute("user_id");

    if(userId!=null)
    {
        session.invalidate();
    }

    response.sendRedirect(request.getContextPath() + "/member/login");
%>
<script>
    location.href = '../index';
</script>
</html>