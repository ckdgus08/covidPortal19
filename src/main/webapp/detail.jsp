<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<input>
<%@ include file="/member/memberSessionCheck.jsp" %>
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
				<a class="nav-link" href="detail">detail</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>

<div class="container">

	<div class="jumbotron" style="margin-top: 20px;">

		<div style="margin: auto; text-align: center;">
			<h4>조회 할 기간을 선택하세요. ( 기간 길게 잡으면 오래 걸릴 수 있습니다.)</h4>
			<form action="detail" method="post">
				<select name="startYear">
					<option value="2020" selected>2020년</option>
				</select>
				<select name="startMonth">
					<option value="01" selected>1</option>
					<% for (int i = 2; i <= 12; i++) {
					%>
					<option value=<%=String.format("%02d", i)%>><%=i%>
					</option>
					<%
						}
					%>
				</select>
				<select name="startDay">
					<option value="01" selected>1</option>

					<% for (int i = 2; i <= 31; i++) {
					%>
					<option value=<%=String.format("%02d", i)%>><%=i%>
					</option>
					<%
						}
					%>
				</select>

				~

				<select name="endYear">
					<option value="2020" selected>2020년</option>
				</select>
				<select name="endMonth">
					<option value="01" selected>1</option>
					<% for (int i = 2; i <= 12; i++) {
					%>
					<option value=<%=String.format("%02d", i)%>><%=i%>
					</option>
					<%
						}
					%>
				</select>
				<select name="endDay">
					<option value="01" selected>1</option>

					<% for (int i = 2; i <= 31; i++) {
					%>
					<option value=<%=String.format("%02d", i)%>><%=i%>
					</option>
					<%
						}
					%>
				</select>
				<div>
					<input type="submit">
				</div>
			</form>

			<table border="1px solid black" style="text-align: center; margin: auto; width: 80%">
				<thead style="background-color: darkgrey;">
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
					<td><%= d.getStateDt()%>
					</td>
					<td><%= d.getDecideCnt()%>
					</td>
					<td><%= d.getClearCnt()%>
					</td>
					<td><%= d.getExamCnt()%>
					</td>
					<td><%= d.getDeathCnt()%>
					</td>
					<td><%= d.getCareCnt()%>
					</td>
					<td><%= d.getResutlNegCnt()%>
					</td>
					<td><%= d.getAccExamCnt()%>
					</td>
					<td><%= d.getAccDefRate()%>
					</td>

				</tr>
				<%
					}
				%>
				</tbody>

			</table>
		</div>
	</div>
</div>
</body>
</html>