<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adicionar Livro</title>
</head>
<body>
<h1>Adicionar Novo Livro</h1>
	<form method="post" action="AdicionarLivroServlet">
		Id: <input type="text" name="id"/>
		Nome: <input type="text" name="nome"/>
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>