<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Tarefas</title>
</head>

<%@ page import="java.util.*,mvc.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<body>
	<h2>LISTA DE TAREFAS</h2>
	

	
	<p>
	<c:forEach var='tarefa' items='${listaTarefas}'>
	<table>
	Id: ${tarefa.id }
	<br>
	Descrição: ${tarefa.descricao }
	</table>
	</c:forEach>
	</p>
	<br>


	 
	<form action="criaTarefa" method="post" enctype="multipart/form-data">
		 <input type="submit" value="Nova Tarefa" />
	</form>
	
	<form action="updateTarefa" method="post">
		<input type="submit" value="Alterar Tarefa">
	</form>
	
	<form action="apagaTarefa" method="post">
		<input type="submit" value="Remover Tarefa">
	</form>
	<p><a href="menuPrincipal">Voltar ao menu</a></p>
</body>
</html>