<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Livros Disponíveis</title>
        <meta charset='UTF-8'>
    </head>
    <body>
        <h1>Livros Disponiveis</h1>
			<table border="5">
					<tr>
						<th>Id:</th>
						<th>Nome:</th>
					</tr>
	            <c:forEach var="livros" items="${listaLivros}">
	                <tr>
	                    <td><c:out value="${livros.idLivro}"/></td>
	                    <td><c:out value="${livros.nomeLivro}"/></td>
	                </tr>
	            </c:forEach>
			</table>
			<p>
	<input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>