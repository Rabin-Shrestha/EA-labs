<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Casts</title>
</head>
<body>
	<form action="../castEdit/${cast.id}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${cast.name}" /> </td>
		</tr>
		<tr>
			<td>BirthPlace:</td>
			<td><input type="text" name="birthPlace" value="${cast.birthPlace}" /> </td>
		</tr>
		<tr>
			<td>Charcater Name:</td>
			<td><input type="text" name="charcaterName" value="${cast.charcaterName}" /> </td>
		</tr>
		<tr>
			<td>Biography:</td>
			<td><input type="text" name="biography" value="${cast.biography}" /> </td>
		</tr>
	</table>
	<input type="submit" value="Update"/>
	</form>
	<form action="delete?castId=${cast.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>
