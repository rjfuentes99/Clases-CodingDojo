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

        <h1>Actual Time</h1>

        <h2>
            <c:out value="${Time}">

            </c:out>
        </h2>
    </div>

    <script>alert("Esta es la plantilla de Hora Actual");</script>
</body>
</html>