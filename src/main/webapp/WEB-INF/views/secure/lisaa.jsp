<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Lisää paino</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>
	<h1>
		LISÄÄ UUSI PAINO
	</h1>
		<form:form modelAttribute="uusiPaino" method="post">
		  	<fieldset>		
				<p>
					<form:label path="paino">Paino (kg):</form:label><br/>
					<form:input path="paino" /> <form:errors path="paino" cssClass="Virheteksti"/>		
				</p>
				
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
		
<p><a href="../main">Takaisin etusivulle</a></p>
</body>
</html>