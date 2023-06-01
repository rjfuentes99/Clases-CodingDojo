<%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <div class="container">

        <h1>Actual Date</h1>

        <h2>
            <c:out value="${Date}">

            </c:out>
        </h2>
    </div>
    <script src="app.js">alert("Esta es la plantilla de Fecha");</script>
</body>
</html>