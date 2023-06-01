<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <div class="container">
		<!--Menu-->
        <div class="top">
            <a href="/new"><h2>Add New</h2></a>
            <a href="/topten"><h2>Top Songs</h2></a>
            <div class="formright">
				<form action="/search" method="post">
					<input class="form" type="submit" value="Search Artists">
					<input class="form" type="text" name="artista" placeholder="Artist">
				</form>
			</div>
        </div>
		<!--Formulario-->
        <table class="table table-striped table-hover table-bordered tblbrd blkbrd">
		    <thead>
		        <tr>
		            <th scope="col">Title</th>
		            <th scope="col">Rating</th>
		            <th scope="col">Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${canciones}" var="cancion">
		        <tr>
		            <td><a href="/songs/${cancion.getId()}"><c:out value="${cancion.getTitulo()}"/></a></td>
		            <td><c:out value="${cancion.getRating()}"/></td>
                    <td>
						<form action="/delete/${cancion.getId()}" method="post">
                            <input type="hidden" name="_method" value="DELETE" />
                            <input type="submit" value="Eliminar" class="btn btn-danger"/>
                        </form>
					</td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
    </div>
</body>
</html>