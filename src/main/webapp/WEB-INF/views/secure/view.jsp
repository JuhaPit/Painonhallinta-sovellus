<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisätyt painot</title>
<link rel="stylesheet" type="text/css"
	href="../resources/styles/common.css">
</head>
<body>
<h1>LISÄTYT PAINOT</h1>

<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>

<table>
			<caption>PAINOT</caption>
			<thead>
				<tr>
					<td>Päivämäärä</td>
					<td>Paino</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${painotAttr}" var="paino">
					<tr>
						<td><c:out value="${paino.pvm}" /></td>
						<td><c:out value="${paino.paino} kg" /></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			
<p><a href="../main">Takaisin etusivulle</a></p>

</body>
</html>