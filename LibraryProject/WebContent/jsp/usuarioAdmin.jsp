<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario Administrador</title>
</head>
<body>
	<h1>Usuario: ${sessionScope.username}</h1>
	
	
	<A HREF='${pageContext.request.contextPath}/adicionarUsuario.jsp'><button>Adicionar Usuario</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/removerUsuario.jsp'><button>Remover Usuario</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/UsuariosTotais'><button>Usuarios Cadastrados</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/adicionarLivro.jsp'><button>Adicionar Livro</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/removerLivro.jsp'><button>Remover Livro</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/LivrosDisponiveisServlet'><button>Livros Disponíveis</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/realizarEmprestimo.jsp'><button>Realizar Empréstimo</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/devolucao.jsp'><button>Devolução de Empréstimo</button></A>
	<p>
	<A HREF='${pageContext.request.contextPath}/EmprestimosTotais'><button>Empréstimos Totais</button></A>
	<p>
	<p>
	<input type="button" value="Voltar ao menu" onClick="history.go(-1)">

	
	
</body>
</html>