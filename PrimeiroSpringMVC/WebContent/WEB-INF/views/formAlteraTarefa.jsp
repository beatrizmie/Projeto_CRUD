<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
	<h3>Alterar tarefas</h3>
 	<form action="alteraTarefa" method="post"> Id: <br />
 		<textarea name="descricao" rows="1" cols="10"></textarea><br>
 		<input type="submit" value="Alterar">
 	</form>
</body>
</html>