<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lenguajes</title>
</head>
<body>
    <h1>Lenguajes</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Creador</th>
                <th>Version</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lenguajes}" var="lenguaje">
                <tr>
                    <td><c:out value="${lenguaje.getNombre()}" /></td>
                    <td><c:out value="${lenguaje.getCreador()}" /></td>
                    <td><c:out value="${lenguaje.getVersion()}" /></td>
                    <td>
                        <form action="/delete/${lenguaje.getId()}" method="post">
                            <input type="hidden" name="_method" value="DELETE" />
                            <input type="submit" value="Eliminar" class="btn btn-danger"/>
                        </form>
                        <a href="/languages/${lenguaje.getId()}" class="btn btn-success">Ver</a>
                        <a href="/edit/${lenguaje.getId()}" class="btn btn-warning">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr>
    <h2>Nuevo Lenguaje</h2>
    <form:form action="/lenguages" method="POST" modelAttribute="nuevoLenguaje">
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

</body>
</html>