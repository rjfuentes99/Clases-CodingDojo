<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro e Inicio de Sesion</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <h2>Registrate</h2>
                <!-- Mi form form ya me crea un objeto y BindingResult solo funciona con form:form-->
                <form:form action="/register" method="post" modelAttribute="nuevoUsuario">
                    <div class="form-group">
                        <form:label path="name">Nombre</form:label>
                        <form:input path="name" class="form-control"></form:input>
                        <form:errors path="name" class="text-danger"></form:errors>
                    </div>
                    <div class="form-group">
                        <form:label path="email">E-mail</form:label>
                        <form:input path="email" class="form-control"></form:input>
                        <form:errors path="email" class="text-danger"></form:errors>
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password</form:label>
                        <form:password path="password" class="form-control"></form:password>
                        <form:errors path="password" class="text-danger"></form:errors>
                    </div>
                    <div class="form-group">
                        <form:label path="confirm">Confirm Password</form:label>
                        <form:password path="confirm" class="form-control"></form:password>
                        <form:errors path="confirm" class="text-danger"></form:errors>
                    </div>
                    <input type="submit" value="Registrarme" class="btn btn-primary">
                </form:form>
            </div>
            <div class="col">
                <h2>Inicia Sesion</h2>
                <!--Errores-->
                <p class="text-danger">
                    ${error_login}
                </p>
                <form action="/login" method="post">
                    <div class="form-group">
                        <label>E-mail</label>
                        <input type="email" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label for="">Password</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <input type="submit" value="Iniciar Sesion" class="btn btn-success">
                </form>
            </div>
        </div>
    </div>
</body>
</html>