<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario Normal</title>
</head>
<body>
	<h1>Usuario: ${sessionScope.username}</h1>
	<p>
	<A HREF='${pageContext.request.contextPath}/LivrosDisponiveisServlet'><button>Livros Disponíveis</button></A>
	<p>
	<form method="post" action="EmprestimoUsuario">
		Insira seu ID para consultar emprestimos:
		<p>
		<input type="text" name="idUsuario"/>
		<p>
		<input type="submit" value="Consultar"/>
	</form>
</body>
</html>