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
 * Servlet implementation class DevolverEmprestimo
 */
@WebServlet("/DevolverEmprestimo")
public class DevolverEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DevolverEmprestimo() {
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
		String idEmprestimo = request.getParameter("idEmprestimo");
		String idLivro = request.getParameter("idLivro");
		String nomeLivro = request.getParameter("nomeLivro");
		
		EmprestimoDAO removerEmprestimo = new EmprestimoDAO();
		removerEmprestimo.removerEmprestimo(idEmprestimo);
		
		LivroDAO devolucao = new LivroDAO();
		devolucao.inserir(idLivro, nomeLivro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/livroSucess.jsp");
		rd.forward(request, response);
		
		
		
		
		
	}

}
