<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Bem vindo ${ user}!
	<form action="/CRUD_P1/BlocoDeNotas.jsp">
	<input type='submit' value='Continuar'>
	<input type='hidden' value=${ user} name='user'>
	<input type='hidden' value=${ id} name='id'>
	</form>
</body>
</html>