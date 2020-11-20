<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Realizar Emprestimo</title>
</head>
<body>
	<h1>Realizar Emprestimo</h1>
	<form method="post" action="EmprestimoServlet">
			ID Livro: <input type="text" name="idLivro"/>
			Nome do Livro: <input type="text" name="nomeLivro"/>
			<br>
			<br>
			ID Usuario: <input type="text" name="idUsuario"/>
			Nome do Usuario: <input type="text" name="nomeUsuario"/>
			<br>
			<br>
			<input type="submit" value="Emprestar"/>
		</form>
		<p>
	<input type="button" value="Voltar" onClick="history.go(-1)">
</body>
</html>