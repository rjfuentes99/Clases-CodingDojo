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
        <form:form action="/edit/${lenguaje.id}" method="POST" modelAttribute="nuevoLenguaje">
            <input type="hidden" name="_method" value="PUT" />
            <h1>Editar Lenguaje</h1>
            <div class="form-group">
                <form:label path="nombre">Nombre</form:label>
                <form:input path="nombre" class="form-control"></form:input>
                <form:errors path="nombre" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="creador">Creador</form:label>
                <form:input path="creador" class="form-control"></form:input>
                <form:errors path="creador" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="version">Version</form:label>
                <form:input path="version" class="form-control"></form:input>
                <form:errors path="version" class="text-danger"></form:errors>
            </div>
            <input type="submit" value="Guardar" class="btn btn-success" />
        </form:form>
    </div>
</body>
</html>