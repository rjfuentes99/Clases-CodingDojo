<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva Pregunta</title>
</head>
<body>
    <div class="container">
        <h1>Nueva pregunta</h1>
        <form:form action="/nueva_pregunta" method="post" modelAttribute="question">
            <div class="form-group">
                <form:label path="pregunta">Pregunta</form:label>
                <form:input path="pregunta" class="form-control"></form:input>
                <form:errors path="pregunta" class="text-danger"></form:errors>
            </div>
            <div class="form-group">
                <label for="">Etiquetas</label>
                <input type="text" class="form-control" name="etiquetas"/>
            </div>
            <input type="submit" class="btn btn-success" value="Guardar" />
        </form:form>
    </div>
</body>
</html>