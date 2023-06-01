<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva Respuesta</title>
</head>
<body>
    <div class="container">
        <h1>${question.pregunta}</h1>
        <div>
            <c:forEach items="${question.tags}" var="tag">
                <span class="badge bg-info">${tag.etiqueta}</span>
            </c:forEach>
        </div>
        <div class="row">
            <div class="col-6">
                <table class="table-hover table">
                    <thead>
                        <tr>
                            <th>Respuestas</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${question.answers}" var="anw">
                            <tr>
                                <td>${anw.respuesta}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-6">
                <h2>Agrega tu respuesta</h2>
                <form:form action="/nueva_respuesta/${question.id}" method="post" modelAttribute="answer">
                    <form:label path="respuesta">Respuesta</form:label>
                    <form:textarea path="respuesta" class="form-control" />
                    <form:errors path="respuesta" class="text-danger" />
                    <input type="submit" class="btn btn-primary" value="Ingresar Respuesta">
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>