<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Usuarios Totais</title>
        <meta charset='UTF-8'>
    </head>
    <body>
        <h1>Usuarios Totais</h1>
			<table border="5">
					<tr>
						<th>Usuario ID:</th>
						<th>Usuario Nome:</th>

					</tr>
	            <c:forEach var="usuario" items="${listaUsuarios}">
	                <tr>
	                	<td><c:out value="${usuario.idUsuario}"/></td>
	                    <td><c:out value="${usuario.nomeUsuario}"/></td>
	                </tr>
	            </c:forEach>
			</table>
			<p>
	<input type="button" value="Voltar" onClick="history.go(-1)">
    </body>
</html>