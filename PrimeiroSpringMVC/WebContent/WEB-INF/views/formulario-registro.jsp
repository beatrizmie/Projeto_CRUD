<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h2>Registre-se aqui!</h2>
	<form action="efetuaRegistro" method="post" enctype="multipart/form-data">
		 Login: <input type="text" name="login" /> <br/>
		 Senha: <input type="password" name="senha" /> <br/>
		 Foto: <input type="file" name="foto"/> <br/><br/>
		 <p><input type="submit" value="Registrar" />
	</form>
</body>
</html>