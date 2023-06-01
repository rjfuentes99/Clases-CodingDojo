<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/licenses/create" method="post" modelAttribute="license">
		<form:label path="person">Name</form:label>
		<form:select path="person">
			<c:forEach items="${persons}" var="person">
				<form:option value="${person.id}">
					<c:out value="${person.firstName}  ${person.lastName}" />
				</form:option>
			</c:forEach>
		</form:select>
		<form:label path="state">State: 
				<form:input type="text" path="state" />
		</form:label>
		<br>
		<form:label path="expiration_date">Expiration Date: 
				<form:errors path="expiration_date" />
			<form:input type="date" path="expiration_date" />
		</form:label>
		<br>
		<input type="submit" value="Create">

	</form:form>
</body>
</html>