<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cursos</title>
</head>
<body>
	<div class="container">
		<nav class="d-flex justify-content-between align-items-center">
			<h1>Bienvenid@ ${user_session.first_name}</h1>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesion</a>
		</nav>
		<div class="row">
			<h2>Cursos</h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Curso</th>
						<th>Lider de curso</th>
						<th>Capacidad</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${all_courses}" var="p">
						<tr>
							<td><a href="/course/info/${p.id}">${p.titulo}</a></td>
							<td>${p.instructor}</td>
							<td>${p.attendees.size()} / ${p.capacidad}</td>
							<td>
								<c:if test="${p.planner.id == user.id}">
									<span>Asistira</span>
								</c:if>
								<c:if test="${p.planner.id != user.id}">
                                    <c:choose>
                                        <c:when test="${p.attendees.contains(user)}">
                                            <span>Asistira</span>
                                        </c:when>
										<c:otherwise>
											<a href="/course/join/${p.id}" class="btn btn-info">Unirme</a>
										</c:otherwise>
                                    </c:choose>
                                </c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="/new" class="btn btn-success">Nuevo Curso</a>
	</div>

</body>
</html>