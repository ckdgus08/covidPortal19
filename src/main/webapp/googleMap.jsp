<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  errorPage="error.jsp"%>
<html>

<head>

	<!-- bootstrap 파일 불러오기 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>



	<title>코로나19(covid19) 종합 포털 사이트</title>
	<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<%--	<script--%>
<%--			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCawUvo6vhrdecSUeco460_j5BdXLbXirM&callback=initMap&libraries=&v=weekly"--%>
<%--			defer--%>
<%--	></script>--%>
	<script defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCawUvo6vhrdecSUeco460_j5BdXLbXirM&libraries=places&callback=initMap">
	</script>
	<style type="text/css">
        /* Always set the map height explicitly to define the size of the div
		 * element that contains the map. */
        #map {
            height: 50%;
        }

	</style>
	<script>

        var map;
        var service;
        var infowindow;

        function initMap() {
            var sydney = new google.maps.LatLng(-33.867, 151.195);

            infowindow = new google.maps.InfoWindow();

            map = new google.maps.Map(
                document.getElementById('map'), {
                    center: { lat: 37.631734, lng: 127.077614 },
                    zoom: 17,
                });

            var request = {
                query: '보건소',
                fields: ['name', 'geometry'],
            };

            var service = new google.maps.places.PlacesService(map);

            service.findPlaceFromQuery(request, function(results, status) {
                if (status === google.maps.places.PlacesServiceStatus.OK) {
                    for (var i = 0; i < results.length; i++) {
                        createMarker(results[i]);
                    }
                    map.setCenter(results[0].geometry.location);
                }
            });
        }


        function createMarker(place) {
            const marker = new google.maps.Marker({
                map,
                position: place.geometry.location,
            });
            google.maps.event.addListener(marker, "click", () => {
                infowindow.setContent(place.name);
                infowindow.open(map);
            });
        }
	</script>
</head>
<body>
<%@ include file="/member/memberSessionCheck.jsp" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="index.jsp">Logo</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="googleMap.jsp">map</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="detail">detail</a>
			</li>
			<li class="nav-item">
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

<div class="container">
<h1> 공릉에서 가장 가까운 코로나 보건소를 찾아줍니다. </h1>
<div id="map"></div>
</div>

</body>

<footer>
	<jsp:include page="inner/footer.jsp"/>
</footer>

</html>