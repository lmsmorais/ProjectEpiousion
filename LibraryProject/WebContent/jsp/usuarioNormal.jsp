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
		<p>
		<input type="submit" value="Consultar Emprestimos"/>
	</form>
	<p>
	<input type="button" value="Voltar ao login" onClick="history.go(-1)">
</body>
</html>