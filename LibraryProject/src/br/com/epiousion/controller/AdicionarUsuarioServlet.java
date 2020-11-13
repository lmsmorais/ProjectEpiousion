package br.com.epiousion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.epiousion.dao.UsuarioDAO;

/**
 * Servlet implementation class AdicionarUsuarioServlet
 */
@WebServlet("/AdicionarUsuarioServlet")
public class AdicionarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarUsuarioServlet() {
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
		String nomeUsuario = request.getParameter("nomeUsuario");
		String senhaUsuario = request.getParameter("senhaUsuario");
		
		UsuarioDAO novoUsuario = new UsuarioDAO();
		boolean inserir = novoUsuario.confere(nomeUsuario, senhaUsuario);
		
		RequestDispatcher rd;
		if(inserir) {
			
			rd = request.getRequestDispatcher("/jsp/livroFail.jsp");
		} else {
			novoUsuario.inserir(nomeUsuario, senhaUsuario);
			rd = request.getRequestDispatcher("/jsp/livroSucess.jsp");
		}
		rd.forward(request, response);
	}

}
