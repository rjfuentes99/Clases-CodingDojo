<%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lenguaje</title>
</head>
<body>

    <h1>Lenguajes</h1>
    <p>Nombre: <c:out value="${languaje.getNombre()}" /></p>
    <p>Creador: <c:out value="${languaje.getCreador()}" /></p>
    <p>Version: <c:out value="${languaje.getVersion()}"/></p>
    <a href="/">Edit User</a>
    <form action="/" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>

</body>