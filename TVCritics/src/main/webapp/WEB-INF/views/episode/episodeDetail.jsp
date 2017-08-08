<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casts</title>
</head>
<body>
	<form action="../episodeEdit/${episode.id}" method="post">
	<table>
		<tr>
			<td>Aired Date:</td>
			<td><input type="text" name="airedDate" value="${episode.airedDate}" /> </td>
		</tr>
		<tr>
			<td>Comment:</td>
			<td><input type="text" name="comment" value="${episode.comment}" /> </td>
		</tr>
		<tr>
			<td>Rating:</td>
			<td><input type="number" name="rating" value="${episode.rating}" /> </td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${episode.description}" /> </td>
		</tr>
	</table>
	<input type="submit" value="Update"/>
	</form>
	<form action="delete?episodeId=${episode.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>
