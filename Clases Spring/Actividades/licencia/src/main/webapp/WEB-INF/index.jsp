<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>

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
	<section>
		<div class="container">
			<div class="notification">
				JAVA Spring Data II - <strong>License</strong> assignment.
			</div>
			<h1>New Person</h1>

			<form:form action="/create/person" method="post"
				modelAttribute="person">
				<p>
					<form:label path="firstName">First Name: </form:label>
					<form:errors path="firstName" />
					<form:input path="firstName" type="text" />
				</p>
				<p>
					<form:label path="lastName">Last Name</form:label>
					<form:errors path="lastName" />
					<form:input path="lastName" type="text" />
				</p>
				<input type="submit" value="Create" />
			</form:form>
		</div>
	</section>
</body>
</html>