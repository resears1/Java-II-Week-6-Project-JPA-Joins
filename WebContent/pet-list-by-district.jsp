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
<form method="post" action="listNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allLists}" var="currentlist">
			<tr>
				<td><input type="radio" name="id" value="${currentlist.id}"></td>
				<td><h2>${currentlist.listName}</h2></td>
			</tr>
			<tr>
				<td colspan="3">Creation Date: ${currentlist.creationDate}</td>
			</tr>
			<tr>
				<td colspan="3">District: ${currentlist.district.districtName}</td>
			</tr>
			<c:forEach var="listVal" items="${currentlist.listOfPets}">
				<tr>
					<td></td>
					<td colspan="3">${listVal.type}, ${listVal.name}, ${listVal.owner}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToItem">
	<input type="submit" value="delete" name="doThisToItem">
	<input type="submit" value="add" name="doThisToItem">
</form>
<a href="addPetsForListServlet">Create a new List</a>
<a href="index.html">Insert a new pet</a>
</body>
</html>