<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dojo OverFlow</title>
</head>
<body>
    <div class="container">
        <h1>Dojo Overflow</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Pregunta</th>
                    <th>Etiquetas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${questions}" var="question">
                    <tr>
                        <td>
                            <a href="/nueva_respuesta/${question.id}">${question.pregunta}</a>
                        </td>
                        <td>
                            <ul>
                                <c:forEach items="${question.tags}" var="tag">
                                    <li>${tag.etiqueta}</li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/nueva_pregunta" class="btn btn-success">Nueva Pregunta</a>
    </div>
</body>
</html>