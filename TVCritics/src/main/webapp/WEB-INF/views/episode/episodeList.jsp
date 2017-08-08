<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Episodes</title>
</head>
<body>
	<h1>Episode Information</h1>
	<table>
	<c:forEach var="episode" items="${episodes}">
	<tr>
		<td>${episode.airedDate}</td>
		<td>${episode.comment}</td>
		<td>${episode.rating}</td>
		<td>${episode.description}</td>
		<td><a href="episodeEdit/${episode.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addEpisode"> Add a Episode</a>
</body>
</html>