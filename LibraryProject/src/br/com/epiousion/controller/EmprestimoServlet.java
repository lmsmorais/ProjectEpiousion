package br.com.epiousion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.epiousion.dao.EmprestimoDAO;
import br.com.epiousion.dao.LivroDAO;

/**
 * Servlet implementation class EmprestimoServlet
 */
@WebServlet("/EmprestimoServlet")
public class EmprestimoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprestimoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idLivro = request.getParameter("idLivro");
		String nomeLivro = request.getParameter("nomeLivro");
		String idUsuario = request.getParameter("idUsuario");
		String nomeUsuario = request.getParameter("nomeUsuario");
		
		EmprestimoDAO emprestarLivro = new EmprestimoDAO();
		boolean emprestimo = emprestarLivro.emprestimo(idLivro, nomeLivro, idUsuario, nomeUsuario);
		
		LivroDAO removerLivro = new LivroDAO();
		removerLivro.remover(idLivro);
		
		RequestDispatcher rd;
		if(emprestimo) {
			rd = request.getRequestDispatcher("/jsp/livroSucess.jsp");
		} else {
			rd = request.getRequestDispatcher("/jsp/livroFail.jsp");
		}
		rd.forward(request, response);
		
	}

}
