<%@  taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h1>Hola mundo en Spring con Plantillas</h1>
    <h2>
        <c:out value="${titulo}"></c:out>
    </h2>
    <ul>
        <c:forEach var="usuario" items="${usuarios}">
            <li>
                <c:out value="${usuario}"></c:out>
                <c:if test="${usuario == 'Juana'}">
                    ;)
                </c:if>
            </li>
        </c:forEach>
    </ul>
</body>
</html>