<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Tu puntuacion: ${gold}</h1>
		<div class="row">
			<div class="col">
				<h3>Granja</h3>
				<p>Ganas 10-20 puntos</p>
				<form action="/oro" method="post">
					<input type="hidden" value="granja" name="lugar" />
					<input type="submit" class="btn btn-info" value="¡Encontrar Oro!" />
				</form>
			</div>
			<div class="col">
				<h3>Cueva</h3>
				<p>Ganas 5-10 puntos</p>
				<form action="/oro" method="post">
					<input type="hidden" value="cueva" name="lugar" />
					<input type="submit" class="btn btn-info" value="¡Encontrar Oro!" />
				</form>
			</div>
			<div class="col">
				<h3>Casa</h3>
				<p>Ganas 2-5 puntos</p>
				<form action="/oro" method="post">
					<input type="hidden" value="casa" name="lugar" />
					<input type="submit" class="btn btn-info" value="¡Encontrar Oro!" />
				</form>
			</div>
			<div class="col">
				<h3>Casino ;)</h3>
				<p>Ganas/Pierdes 0-10 puntos</p>
				<form action="/oro" method="post">
					<input type="hidden" value="casino" name="lugar" />
					<input type="submit" class="btn btn-info" value="¡Encontrar Oro!" />
				</form>
			</div>
		</div>
		<div class="row">
			<c:forEach var="activity" items="${activities}">
				<c:if test="${activity.contains('ganaste')}">
					<p class="text-success">${activity}</p>
				</c:if>
				<c:if test="${activity.contains('perdiste')}">
					<p class="text-danger">${activity}</p>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>