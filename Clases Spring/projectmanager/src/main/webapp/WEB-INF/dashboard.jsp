<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project Manager</title>
</head>
<body>
	<div class="container">
		<nav class="d-flex justify-content-between align-items-center">
			<h1>Bienvenid@ ${user_session.first_name}</h1>

			<a href="/projects/new" class="btn btn-success">Nuevo Projecto</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesion</a>
		</nav>
		<div class="row">
			<h2>Todos los Proyectos</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Curso</th>
						<th>Lider de curso</th>
						<th>Fecha limite</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resto_projectos}" var="p">
						<tr>
							<td><a href="/projects/show/${p.id}">${p.title}</a></td>
							<td>${p.lead.first_name}</td>
							<td>${p.due_date}</td>
							<td>
								<a href="/projects/join/${p.id}" class="btn btn-info">Unirme</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<h2>Mis Proyectos</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Proyecto</th>
						<th>Lider de Proyecto</th>
						<th>Fecha limite</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mis_projectos}" var="p">
						<tr>
							<td><a href="/projects/show/${p.id}">${p.title}</a></td>
							<td>${p.lead.first_name}</td>
							<td>${p.due_date}</td>
							<td>
								<c:if test="${p.lead.id == user_session.id}">
									<a href="/projects/edit/${p.id}" class="btn btn-warning">Editar</a>
								</c:if>
								<c:if test="${p.lead.id != user_session.id}">
									<a href="/projects/leave/${p.id}" class="btn btn-danger">Salir</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>