<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adicionar Usu�rio</title>
</head>
<body>
<h1>Adicionar Novo Usu�rio</h1>
	<form method="post" action="AdicionarUsuarioServlet">
		Nome: <input type="text" name="nomeUsuario"/>
		Senha: <input type="text" name="senhaUsuario"/>
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>