<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casts</title>
</head>
<body>
	<h1>Cast Information</h1>
	<table>
	<c:forEach var="cast" items="${casts}">
	<tr>
		<td>${cast.name}</td>
		<td>${cast.birthPlace}</td>
		<td>${cast.charcaterName}</td>
		<td>${cast.biography}</td>
		<td><a href="castEdit/${cast.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addCast"> Add a Cast</a>
</body>
</html>
