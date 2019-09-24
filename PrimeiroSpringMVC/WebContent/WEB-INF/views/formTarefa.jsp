<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
	<h3>Adicionar tarefas</h3>
 	<form action="adicionaTarefa" method="post"> Descrição: <br />
 		<textarea name="descricao" rows="6" cols="80"></textarea><br>
 		<p> Finalizado:
 		<select id="finalizado">
 			<option value="sim" >Sim</option>
 			<option value="nao" >Não</option>
 		</select><br>
<!--  		<p> Data de finalização:
 		<input type="date" value="dataFinalizacao"><br> -->
 		<p><input type="submit" value="Adicionar">
 	</form>
</body>
</html>