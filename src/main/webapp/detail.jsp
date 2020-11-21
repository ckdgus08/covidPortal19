<%@ page import="java.time.LocalDateTime" %>
<%@ page import="org.apache.logging.log4j.message.StringFormattedMessage" %>
<%@ page import="com.covidPotar19.service.DetailService" %>
<%@ page import="com.covidPotar19.repository.DetailRepository" %>
<%@ page import="org.apache.catalina.core.ApplicationContext" %>
<%@ page import="org.apache.catalina.core.StandardContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="com.covidPotar19.domain.Detail" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<%

	List<Detail> result = (List) request.getAttribute("result");

%>

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
			<li class="nav-item active">
				<a class="nav-link" href="detail.jsp">detail</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>

<table border="1px solid black" style="text-align: center">
	<thead>
	<tr>
		<td>날짜</td>
		<td>총 확진자 수</td>
		<td>격리해제 수</td>
		<td>검사진행 수</td>
		<td>사망자 수</td>
		<td>치료중 환자 수</td>
		<td>결과 음성 수</td>
		<td>누적검사 수</td>
		<td>누적 확진률</td>
	</tr>
	</thead>
	<tbody>
	<% for (Detail d : result) {
	%>
	<tr>
		<td><%= d.getStateDt()%></td>
		<td><%= d.getDecideCnt()%></td>
		<td><%= d.getClearCnt()%></td>
		<td><%= d.getExamCnt()%></td>
		<td><%= d.getDeathCnt()%></td>
		<td><%= d.getCareCnt()%></td>
		<td><%= d.getResutlNegCnt()%></td>
		<td><%= d.getAccExamCnt()%></td>
		<td><%= d.getAccDefRate()%></td>

	</tr>
	<%
		}
	%>
	</tbody>

</table>

<%--
result.setStateTime(getTagValue("stateTime", eElement));
                    result.setDecideCnt(getTagValue("decideCnt", eElement));
                    result.setClearCnt(getTagValue("clearCnt", eElement));
                    result.setExamCnt(getTagValue("examCnt", eElement));
                    result.setDeathCnt(getTagValue("deathCnt", eElement));
                    result.setCareCnt(getTagValue("careCnt", eElement));
                    result.setResutlNegCnt(getTagValue("resutlNegCnt", eElement));
                    result.setAccExamCnt(getTagValue("accExamCnt", eElement));
                    result.setAccExamCompCnt(getTagValue("accExamCompCnt", eElement));
                    result.setAccDefRate(getTagValue("accDefRate", eElement));
                    result.setCreateDt(getTagValue("createDt", eElement));
                    result.setUpdateDt(getTagValue("updateDt", eElement));--%>

</body>
</html>