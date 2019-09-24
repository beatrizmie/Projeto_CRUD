<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
	<h3>Remover tarefas</h3>
 	<form action="removeTarefa" method="post"> Id: <br />
 		<textarea name="id" rows="1" cols="10"></textarea><br>
 		<input type="submit" value="Remover">
 	</form>
</body>
</html>