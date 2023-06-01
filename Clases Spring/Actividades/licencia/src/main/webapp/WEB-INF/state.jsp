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
	<h1><c:out value="${person.firstName} ${person.lastName }"/></h1>
	<h3>License number  <c:out value="${person.license.number}"/></h3>
	<h3>State   <c:out value="${person.license.state}" /></h3>
	
	<%-- <h3>Expiration Date   <c:out value="${person.license.expiration_date}" /></h3> --%>
	
	<h3>Expiration Date   <fmt:formatDate value="${person.license.expiration_date}" pattern="MM-dd-yyyy" /></h3>
</body>
</html>