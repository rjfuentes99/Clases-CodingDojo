<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <nav class="d-flex justify-content-between align-items-center">
            <h1>Welcome ${user_session.name}</h1>
            <a href="/logout" class="btn btn-danger">Cerrar Sesion</a>
        </nav>
        <div class="row">
            <h2>Eventos en mi estado</h2>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Evento</th>
                        <th>Fecha</th>
                        <th>Locacion</th>
                        <th>Estado</th>
                        <th>Planner</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${eventos_miestado}" var="evento">
                        <tr>
                            <td>
                                <a href="/events/${evento.id}">${evento.eventName}</a>
                            </td>
                            <td>${evento.eventDate}</td>
                            <td>${evento.eventLocation}</td>
                            <td>${evento.eventState}</td>
                            <td>${evento.planner.name}</td>
                            <td>
                                <c:if test="${evento.planner.id == user.id}">
                                    <a href="/events/edit/${evento.id}" class="btn btn-warning">Editar</a>
                                    <form action="/events/delete/${evento.id}" method="post">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="submit" value="Eliminar" class="btn btn-danger">
                                    </form>
                                </c:if>
                                <c:if test="${evento.planner.id != user.id}">
                                    <c:choose>
                                        <c:when test="${evento.attendees.contain(user)}">
                                            <span>Asistira - <a href="/events/remove/${evento.id}" class="btn btn-danger"> Ya no quiero asistir</a></span>
                                        </c:when>
                                    </c:choose>
                                    <c:otherwise>
                                        <a href="/events/join/${evento.id}">Asistir</a>
                                    </c:otherwise>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <h2>Eventos fuera de mi estado</h2>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Evento</th>
                        <th>Fecha</th>
                        <th>Locacion</th>
                        <th>Estado</th>
                        <th>Planner</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${eventos_otros}" var="evento">
                        <tr>
                            <td>
                                <a href="/events/${evento.id}">${evento.eventName}</a>
                            </td>
                            <td>${evento.eventDate}</td>
                            <td>${evento.eventLocation}</td>
                            <td>${evento.eventState}</td>
                            <td>${evento.planner.name}</td>
                            <td>
                                <c:if test="${evento.planner.id == user.id}">
                                    <a href="/events/edit/${evento.id}" class="btn btn-warning">Editar</a>
                                    <form action="/events/delete/${evento.id}" method="post">
                                        <input type="hidden" name="_method" value="DELETE">
                                        <input type="submit" value="Eliminar" class="btn btn-danger">
                                    </form>
                                </c:if>
                                
                                <c:if test="${evento.planner.id != user.id}">
                                    <c:choose>
                                        <c:when test="${evento.attendees.contain(user)}">
                                            <span>Asistira - <a href="/events/remove/${evento.id}" class="btn btn-danger"> Ya no quiero asistir</a></span>
                                        </c:when>
                                    </c:choose>
                                    <c:otherwise>
                                        <a href="/events/join/${evento.id}" class="btn btn-info">Asistir</a>
                                    </c:otherwise>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <h2>Crear evento</h2>
            <form:form action="/events/create" method="post" modelAttribute="event">
                <div class="form-group">
                    <form:label path="eventName">Nombre</form:label>
                    <form:input path="eventName" class="form-control"></form:input>
                    <form:errors path="eventName" class="text-danger"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="eventDate">Fecha</form:label>
                    <form:input path="eventDate" type="date" class="form-control"></form:input>
                    <form:errors path="eventDate" class="text-danger"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="eventLocation">Locacion</form:label>
                    <form:input path="eventLocation" class="form-control"></form:input>
                    <form:errors path="eventLocation" class="text-danger"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="eventState">Estado</form:label>
                    <form:select path="eventState" class="form-select">
                        <c:forEach items="${states}" var="state">
                            <option value="${state}">${state}</option>
                        </c:forEach>
                    </form:select>
                </div>
                <form:hidden path="planner" value="${user.id}"></form:hidden>

                <input type="submit" value="Guardar" class="btn btn-primary">

            </form:form>
        </div>
    </div>
</body>
</html>