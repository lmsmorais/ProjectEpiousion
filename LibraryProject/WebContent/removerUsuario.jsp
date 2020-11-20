<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Remover Usuario</h1>
	<form method="post" action="RemoverUsuarioServlet">
		Id Usuário: <input type="text" name="id"/>
		<input type="submit" value="Remover"/>
	</form>
	<p>
	<input type="button" value="Voltar" onClick="history.go(-1)">
</body>
</html>