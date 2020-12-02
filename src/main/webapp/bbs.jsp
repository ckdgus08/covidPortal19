<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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
	<link rel="stylesheet" href="/resources/static/css/bbs.css">

	<title>코로나19(covid19) 종합 포털 사이트</title>
</head>
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
			<li class="nav-item">
				<a class="nav-link" href="detail">detail</a>
			</li>
			<li class="nav-item active">
				<a class="nav-link" href="bbs">게시판</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>
</head>
<body>
<div class="container">
	<div>

		<div>
			<table class="table table-striped">
				<thead>
				<tr class="category">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th style="min-width: 56px;">작성일</th>
					<th>조회수</th>
				</tr>
				</thead>
				<tbody>

				<c:forEach var="n" items="${notice}">
					<tr class="announce">
						<td style="color: black; text-decoration: none; text-align: center;">${n.id}</td>
						<td style="color: black; text-decoration: none; text-align: center;">
							<a style="color: black; text-decoration: none" href="view?bbsID=${n.id}"> ${n.title} </a>
						</td>
						<td style="color: black; text-decoration: none; text-align: center;">${n.username}</td>
						<td style="color: black; text-decoration: none; text-align: center;">${n.date} </td>
						<td style="color: black; text-decoration: none; text-align: center;">${n.count} </td>
					</tr>
				</c:forEach>

				<c:forEach var="n" items="${normal}">
					<tr class="normal">
						<td>${n.id}</td>
						<td>
							<a class="title" href="view?bbsID=${n.id}"> ${n.title} </a>
						</td>
						<td>${n.username}</td>
						<td>${n.date} </td>
						<td>${n.count} </td>
					</tr>
				</c:forEach>


				</tbody>


			</table>

			<br>

			<nav style="text-align: center;">
				<ul class="pagination">
					<li><a href="bbs?pageNumber=1">처음</a></li>

					<li class="active"><a href="bbs?page=1">1
					</a></li>

					<li><a href="bbs?page=2">2
					</a></li>

					<li><a href="bbs?page=3">3
					</a></li>

					<li><a href="bbs?page=4">4
					</a></li>

					<li><a href="bbs?page=5">5
					</a></li>

					<li><a href="bbs?page=6">6
					</a></li>

					<li><a href="bbs?page=7">7
					</a></li>

					<li><a href="bbs?page=8">8
					</a></li>

					<li><a href="bbs?page=9">9
					</a></li>
				</ul>

				<ul class="pagination">
					<a href="write" class="btn btn-primary pull-right">글쓰기</a>
				</ul>

			</nav>

			<br> <br>


		</div>
	</div>
</div>
</body>

<footer>
	<jsp:include page="inner/footer.jsp"/>
</footer>


</html>