<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of Pets</h1>
<form method="post" action="navigationServlet">
<table>
	<c:forEach items="${requestScope.allPets}" var="currentpet">
		<tr>
			<td><input type="radio" name="id" value="${currentpet.id}"></td>
			<td>${currentpet.type}</td>
			<td>${currentpet.name}</td>
			<td>${currentpet.owner}</td>
		</tr>
	</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToItem">
<input type="submit" value="delete" name="doThisToItem">
<input type="submit" value="add" name="doThisToItem">
</form>
</body>
</html>