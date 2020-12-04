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
			<li class="nav-item">
				<a class="nav-link" href="/member/logoutAction.jsp">로그아웃</a>
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
	<div class="row">
		<form method="post" action="writeAction">
			<table class="table table-striped" style="width: 1000px">
				<thead>
				<tr class="category">
					<th colspan="2" class="bbs_content">게시판 글쓰기 양식</th>
				</tr>
				</thead>
				<tbody>
				<tr class="normal">
					<td class="bbs_content">
						<input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50">
					</td>
				</tr>
				<tr class="normal">
					<td class="bbs_content">
                        <textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="4096"
								  style="height: 350px"></textarea>
					</td>
				</tr>
				</tbody>
			</table>
			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">

		</form>
	</div>
</div>
</body>

<footer>
	<jsp:include page="inner/footer.jsp"/>
</footer>


</html>