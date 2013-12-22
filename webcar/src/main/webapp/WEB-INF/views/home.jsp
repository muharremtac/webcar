<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script src="http://code.jquery.com/jquery-1.3.2.min.js"></script>

</head>
<body>
<script>
	$("body").keydown(function(e) {
		if (e.keyCode == 37) { // Left
			$.get("/webcar/ajax?methot=r", function(data) {
				
			});
		} else if (e.keyCode == 39) { // Right
			$.get("/webcar/ajax?methot=l", function(data) {
				
			});
		} else if (e.keyCode == 38) { // Up
			$.get("/webcar/ajax?methot=i", function(data) {
			
			});
		} else if (e.keyCode == 40) { // Down
			$.get("/webcar/ajax?methot=g", function(data) {
				
			});
		} else if (e.keyCode == 32) { // Stop
			$.get("/webcar/ajax?methot=d", function(data) {
				
			});
		}
	});
</script>

	<h1>Webcar</h1>

	<P>Webcar'ı yönetmek için klavyenizden</P>
	<P>İleri gitmek için: ileri ok</P>
	<P>Geri gitmek için: geri ok</P>
	<P>Sola gitmek için: sol ok</P>
	<P>Sağa gitmek için: sağ ok</P>
	<P>Durmak için: space</P>
</body>
</html>
