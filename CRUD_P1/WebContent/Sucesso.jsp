<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso</title>
</head>
<body>
	Nota adicionada com sucesso!
	<form action="/CRUD_P1/BlocoDeNotas.jsp">
	<input type='submit' value='Voltar'>
	<input type='hidden' value=${ user} name='user'>
	<input type='hidden' value=${ id} name='id'>
	</form>
</body>
</html>