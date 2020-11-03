<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>코로나19(covid19) 종합 포털 사이트</title>
	<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
	<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCawUvo6vhrdecSUeco460_j5BdXLbXirM&callback=initMap&libraries=&v=weekly"
			defer
	></script>
	<style type="text/css">
        /* Always set the map height explicitly to define the size of the div
		 * element that contains the map. */
        #map {
            height: 50%;
        }

	</style>
	<script>
        let map;

        function initMap() {
            map = new google.maps.Map(document.getElementById("map"), {
                center: { lat: 37.631734, lng: 127.077614 },
                zoom: 16,
            });
        }
	</script>
</head>
<body>
<div id="map"></div>
</body>
</html>