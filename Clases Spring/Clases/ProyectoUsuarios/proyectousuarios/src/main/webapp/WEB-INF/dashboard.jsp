<%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <div class="container">
        <h1>!Bievenid@ <c:out value="${nombre}"/>!</h1>
    </div>
    <table class="table tabler-hover">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>E-mail</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.getFirst_name()}"></c:out></td>
                    <td><c:out value="${usuario.getLast_name()}"></c:out></td>
                    <td><c:out value="${usuario.getEmail()}"></c:out></td>
                    <td>
                        <form action="/delete/${usuario.getId()}" method="post">
                            <input type="hidden" name="_method" value="DELETE" />
                            <input type="submit" value="Eliminar" class="btn btn-danger"/>
                        </form>
                        <a href="/edit/${usuario.getId()}" class="btn btn-warning">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>