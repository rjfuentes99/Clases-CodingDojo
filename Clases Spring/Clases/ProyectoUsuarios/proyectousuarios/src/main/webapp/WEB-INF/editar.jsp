<%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar</title>
</head>
<body>
    <div class="container">
        <form:form action="/edit/${usuario.id}" method="post" modelAttribute="usuario" >
            <input type="hidden" name="_method" value="PUT" />
            <h1>Editar Usuario</h1>
			<div class="form-group">
				<form:label path="first_name">Nombre</form:label>
				<form:input path="first_name" class="form-control" />
				<form:errors path="first_name" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="last_name">Apellido</form:label>
				<form:input path="last_name" class="form-control" />
				<form:errors path="last_name" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="email">E-mail</form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<input type="submit" value="Guardar" class="btn btn-success" />
		</form:form>
    </div>
</body>
</html>