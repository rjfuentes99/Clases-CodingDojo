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
        <div class="top1">
            <a href="/dashboard"><h2 class="right">Dashboard</h2></a>
        </div>
        <h2>Nueva cancion</h2>
        <form:form action="/new" method="POST" modelAttribute="nuevaCancion">
            <div class="form-group">
                <form:label path="titulo">Cancion</form:label>
                <form:input path="titulo"></form:input>
                <form:errors path="titulo"></form:errors>
            </div>
            <div class="form-group">
                <form:label path="artista">Artista</form:label>
                <form:input path="artista"></form:input>
                <form:errors path="artista"></form:errors>
            </div>
            <div class="form-group">
                    <form:label path="rating">Rating:</form:label>
                    <form:select path="rating">
                        <form:option value="1">1</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="3">4</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="5">5</form:option>
                        <form:option value="6">6</form:option>
                        <form:option value="7">7</form:option>
                        <form:option value="8">8</form:option>
                        <form:option value="9">9</form:option>
                        <form:option value="10">10</form:option>
                    </form:select>
                    <form:errors path="rating"/>
                <input id="btn" type="submit" value="Add Song" class="btn btn-success"/>
            </div>
        </form:form>
    </div>
</body>
</html>