<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Inicio de sesion</title>
</head>
<body>
    <div class="container">

        <div class="row">
            <div class="col sign-up">
                <div class="welcome-back">
                    <div class="message">
                        <h2>Bienvenido</h2>
                        <p>Si ya tienes una cuenta inicia sesion aqui</p>
                        <button class="sign-up-btn">Iniciar sesion</button>
                    </div>
                </div>
                <!-- Mi form form ya me crea un objeto y BindingResult solo funciona con form:form-->
                <form:form class="formulario" action="/register" method="post" modelAttribute="nuevoUsuario">
                    <h2 class="fw-bold text-center py-4">Registrate</h2>
                    <div class="form-group">
                        <form:label path="first_name" class="form-label ">Nombre</form:label>
                        <form:input path="first_name" class="form-control"></form:input>
                        <form:errors path="first_name" class="text-danger"></form:errors>
                    </div>
                    <div class="form-group">
                        <form:label path="email" class="form-label">E-mail</form:label>
                        <form:input path="email" class="form-control"></form:input>
                        <form:errors path="email" class="text-danger"></form:errors>
                    </div>
                    <div class="form-group">
                        <form:label path="password" class="form-label">Password</form:label>
                        <form:password path="password" class="form-control"></form:password>
                        <form:errors path="password" class="text-danger"></form:errors>
                    </div>
                    <div class="form-group">
                        <form:label path="confirm" class="form-label">Confirm Password</form:label>
                        <form:password path="confirm" class="form-control"></form:password>
                        <form:errors path="confirm" class="text-danger"></form:errors>
                    </div>
                    <input type="submit" value="Registrarme" class="btn btn-primary">
                </form:form>
            </div>
            <div class="col sign-in">
                <div class="welcome-back">
                    <div class="message">
                        <h2>Bienvenido</h2>
                        <p>Si aun no tienes una cuenta por favor registrese aqui</p>
                        <button class="sign-in-btn">Registrarse</button>
                    </div>
                </div>
                <form class="formulario" action="/login" method="post">

                    <h2 class="fw-bold text-center py-4">Inicia Sesion</h2>

                    
                    <div class="form-group">
                        <label class="form-label">E-mail</label>
                        <input type="email" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Password</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <p class="text-danger">
                        ${error_login}
                    </p>

                    <input type="submit" value="Iniciar Sesion" class="btn btn-success">
                </form>
            </div>
        </div>
    </div>
    <script>
        const $btnSignIn= document.querySelector('.sign-in-btn'),
        $btnSignUp = document.querySelector('.sign-up-btn'),  
        $signUp = document.querySelector('.sign-up'),
        $signIn  = document.querySelector('.sign-in');

        document.addEventListener('click', e => {
        if (e.target === $btnSignIn || e.target === $btnSignUp) {
            $signIn.classList.toggle('active');
            $signUp.classList.toggle('active')
        }
        });
    </script>
</body>
</html>