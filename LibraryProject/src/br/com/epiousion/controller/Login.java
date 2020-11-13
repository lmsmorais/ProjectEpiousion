package br.com.epiousion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.epiousion.bean.Usuario;
import br.com.epiousion.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		//recebendo os dados de login
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//condi��es para diferenciar usu�rio
		if(username.equals("admin") && password.equals("admin")) {
			HttpSession s = request.getSession();
			
			s.setAttribute("username", username);
			s.setAttribute("password", password);
			
			response.getWriter().append("Usu�rio administrador autenticado!!");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/usuarioAdmin.jsp");
			rd.forward(request, response);
			
		} else if (username != null && password != null) {
			HttpSession s = request.getSession();
			
			s.setAttribute("username", username);
			s.setAttribute("password", password);
			
			UsuarioDAO usuarioLogando = new UsuarioDAO();
			Usuario usuarioId = new Usuario();
			boolean verificar = usuarioLogando.confere(username, password);
			
			RequestDispatcher rd;
			if(verificar) {
				request.getSession().setAttribute("idUsuario", usuarioId.getIdUsuario());
				rd = request.getRequestDispatcher("/jsp/usuarioNormal.jsp");
			} else {
				rd = request.getRequestDispatcher("/jsp/livroFail.jsp");
			}
			rd.forward(request, response);
			
		} else {
			response.getWriter().append("Usu�rio n�o autenticado !!");
		}
		
	}

}
