<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Emprestimos Totais</title>
        <meta charset='UTF-8'>
    </head>
    <body>
        <h1>Emprestimos Totais</h1>
			<table border="5">
					<tr>
						<th>Emprestimo ID:</th>
						<th>Livro ID:</th>
						<th>Livro Nome:</th>
						<th>Usuario ID:</th>
						<th>Usuario Nome:</th>
					</tr>
	            <c:forEach var="emprestimos" items="${listaEmprestimos}">
	                <tr>
	                	<td><c:out value="${emprestimos.idEmprestimo}"/></td>
	                    <td><c:out value="${emprestimos.idLivro}"/></td>
	                    <td><c:out value="${emprestimos.nomeLivro}"/></td>
	                    <td><c:out value="${emprestimos.idUsuario}"/></td>
	                    <td><c:out value="${emprestimos.nomeUsuario}"/></td>
	                </tr>
	            </c:forEach>
			</table>
			<p>
	<input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>