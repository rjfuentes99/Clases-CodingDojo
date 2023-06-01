<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Search</title>
</head>
<body>
	<Div class="container">
		<div class="top">
			<h2 class="left">Songs by artist: <c:out value="${artista}"/></h2>
			<div class="formright">
				<form action="/search" method="post">
					<input class="form2" type="search" name="artista" placeholder="Artist">
					<input class="form2" type="submit" value="New Search">
				</form>
				<a href="/dashboard"><h2 class="right2">Dashboard</h2></a>
			</div>
		</div>
		<table class="table table-striped table-hover table-bordered tblbrd blkbrd">
		    <thead>
		        <tr>
		            <th scope="col">Title</th>
		            <th scope="col">Rating</th>
		            <th scope="col">Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${canciones}" var="cancion">
		        <tr>
		            <td><a href="songs/${cancion.getId()}"><c:out value="${cancion.getTitulo()}"/></a></td>
		            <td><c:out value="${cancion.getRating}"/></td>
					<form action="/delete/${cancion.getId()}" method="post">
						<input type="hidden" name="_method" value="DELETE" />
						<input type="submit" value="Eliminar" class="btn btn-danger"/>
					</form>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</Div>
</body>
</html>