package br.com.epiousion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.epiousion.dao.LivroDAO;

/**
 * Servlet implementation class LivroServlet
 */
@WebServlet("/AdicionarLivroServlet")
public class AdicionarLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarLivroServlet() {
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
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		
		LivroDAO livro = new LivroDAO();
		boolean inserir = livro.inserir(id, nome);
		
		RequestDispatcher rd;
		if(inserir) {
			rd = request.getRequestDispatcher("/jsp/livroSucess.jsp");
		} else {
			rd = request.getRequestDispatcher("/jsp/livroFail.jsp");
		}
		rd.forward(request, response);
	}

}
