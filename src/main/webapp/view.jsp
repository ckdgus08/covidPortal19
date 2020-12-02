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
			<li class="nav-item active">
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
	<div class="row">
		<table class="table table-striped">
			<thead>
			<tr class="category">
				<th colspan="4">게시판 글 보기</th>
			</tr>
			</thead>
			<tbody>
			<tr class="normal">
				<td colspan="4" ass="bbs_title">
					${bbs.title}
				</td>
			</tr>
			<tr class="normal">
				<td colspan="4" class="bbs_content">
					${bbs.username}
				</td>
			</tr>
			<tr class="normal">
				<td colspan="4" class="bbs_content">
					${bbs.content}
				</td>
			</tr>
			</tbody>
		</table>

		<a href="bbs" class="btn btn-primary">목록</a>

		<a href="update?bbsID=${bbs.id}" class="btn btn-primary">수정</a>
		<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction?bbsID=${bbs.id}" class="btn btn-primary">삭제</a>
	</div>
	<br>
	<table class="table table-striped">
		<thead>
		<tr class="category">
			<th>아이디</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		</thead>
		<tbody>

		<c:forEach var="n" items="${bbs.comments}">
			<tr class="normal">
				<td>${n.username}</td>
				<td>${n.content} </td>
				<td>${n.date} </td>
			</tr>
		</c:forEach>


		</tbody>


	</table>
	<br>

	<form method="post" action="commentAction">
		<input type="hidden" name="bbsID" value="${bbs.id}"/>
		<div class="form-group">
                <textarea class="form-control" placeholder="댓글을 입력하세요." name="content" maxlength="200"
						  style="height: 80px; resize: none;"></textarea>
		</div>
		<input type="submit" class="btn btn-primary form-control" value="등록하기">
	</form>

</div>

<br> <br> <br>
</div>
</body>
<footer>
	<jsp:include page="inner/footer.jsp"/>
</footer>


</html>