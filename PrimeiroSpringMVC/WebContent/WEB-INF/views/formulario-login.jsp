<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
 	<h2>Faça seu login!</h2>
 	<form action="efetuaLogin" method="post">
 		Login: <input type="text" name="login" /> <br/>
 		Senha: <input type="password" name="senha" /> <br/>
 		<p><input type="submit" value="Entrar nas tarefas" />
 	</form>
 	<form action="registro" method="post">
 		<p><input type="submit" value="Fazer cadastro">
 	</form>
</body>
</html>