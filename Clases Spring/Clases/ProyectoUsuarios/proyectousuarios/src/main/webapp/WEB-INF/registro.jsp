<%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
</head>
<body>
    <div class="container">
        <h1>Crear Usuario</h1>
        <form action="/registrar" method="post">
            <div>
                <label>Nombre</label>
                <input type="text" name="nombre">
            </div>
            <div>
                <label>Email</label>
                <input type="email" name="email">
            </div>
            <input type="submit" value="Guardar" class="btn btn-success">
        </form>
        <div class="text-danger">
            <c:out value="${error}"/>
        </div>
    </div>
</body>
</html>