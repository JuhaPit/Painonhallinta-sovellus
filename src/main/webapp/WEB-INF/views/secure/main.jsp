<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Etusivu</title>
<link rel="stylesheet" type="text/css"
	href="../resources/styles/common.css">
</head>
<body>
<h1>ETUSIVU</h1>

<h3>Sisäänkirjautuneena: <sec:authentication property="principal.username"/></h3>

<p><a href="painot/uusi">Lisää uusi paino</a></p>
<p><a href="painot/tarkastele">Tarkastele painoja</a></p>





 
<p><a href="../j_spring_security_logout" > Kirjaudu ulos</a></p>

</body>
</html>