<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Curso</title>
</head>
<body>
	<div class="container">
		<nav class="d-flex justify-content-between align-items-center">
		</nav>
		<div class="row">
			<h2>Titulo : ${cursoid.titulo}</h2>
			<h5>Instructor : ${cursoid.instructor}</h5>
            <h5>Capacidad : ${cursoid.attendees.size()}</h5>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Fecha de inscripcion</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cursoid.attendees}" var="p">
                    <tr>
                        <td><c:out value="${p.first_name}"></c:out></td>
                        <td><c:out value="${p.created_at}"></c:out></td>
                        <td>
							<a href="">Remove</a>
						</td>
                    </tr>
                	</c:forEach>
				</tbody>
			</table>
		</div>

			<a href="/course/edit/${cursoid.id}" class="btn btn-warning">Edit</a>

			<form action="/course/delete/${cursoid.id}" method="post">
				<input type="hidden" name="_method" value="DELETE">
				<input type="submit" value="Eliminar" class="btn btn-danger">
			</form>

	</div>

</body>
</html>