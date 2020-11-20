package br.com.epiousion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.epiousion.bean.Emprestimo;
import br.com.epiousion.dao.EmprestimoDAO;

/**
 * Servlet implementation class EmprestimoUsuario
 */
@WebServlet("/EmprestimoUsuario")
public class EmprestimoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmprestimoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmprestimoDAO emprestimo = new EmprestimoDAO();
		List<Emprestimo> emprestimoUsuario = null;
		
		try {
			
			String usuario = (String) request.getSession().getAttribute("username");
			
			emprestimoUsuario = emprestimo.emprestimoUsuario(usuario);
			
			request.setAttribute("listaEmprestimoUsuario", emprestimoUsuario);
			RequestDispatcher rd = request.getRequestDispatcher("emprestimosUsuarioNormal.jsp");
            rd.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
