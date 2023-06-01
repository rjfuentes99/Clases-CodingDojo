<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Project</title>
</head>
<body>
    <div class="container">
        <form:form action="/projects/create" method="post" modelAttribute="project">
            <h1>Crea un nuevo Curso</h1>
            <div class="form-group">
                <form:label path="title">Titulo</form:label>
                <form:input path="title" class="form-control"></form:input>
                <form:errors path="title" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="description">Descripcion</form:label>
                <form:textarea path="description" class="form-control"></form:textarea>
                <form:errors path="description" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="due_date">Fecha limite</form:label>
                <form:input type="date" path="due_date" class="form-control"></form:input>
                <form:errors path="due_date" class="text-danger"></form:errors>
            </div>

            <form:hidden path="lead" value="${user_session.id}"></form:hidden>

            <input type="submit" value="Guardar" class="btn btn-success" />
        </form:form>
    </div>
</body>
</html>