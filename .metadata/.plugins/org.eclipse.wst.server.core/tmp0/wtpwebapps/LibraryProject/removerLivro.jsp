<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remover Livro</title>
</head>
<body>
<h1>Remover Livro</h1>
	<form method="post" action="RemoverLivroServlet">
		Id: <input type="text" name="id"/>
		<input type="submit" value="Remover"/>
	</form>
</body>
</html>