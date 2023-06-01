<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Course</title>
</head>
<body>
    <div class="container">
        <form:form action="/course/create" method="post" modelAttribute="course">
            <h1>Nuevo curso</h1>
            <div class="form-group">
                <form:label path="titulo">Nombre del Curso</form:label>
                <form:input path="titulo" class="form-control"></form:input>
                <form:errors path="titulo" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="instructor">Instructor</form:label>
                <form:input path="instructor" class="form-control"></form:input>
                <form:errors path="instructor" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="capacidad">Capacidad</form:label>
                <form:input path="capacidad" class="form-control"></form:input>
                <form:errors path="capacidad" class="text-danger"></form:errors>
            </div>

            <form:hidden path="planner" value="${user_session.id}"></form:hidden>

            <input type="submit" value="Guardar" class="btn btn-success" />
        </form:form>
    </div>
</body>
</html>