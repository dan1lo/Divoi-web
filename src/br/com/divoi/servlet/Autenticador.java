package br.com.divoi.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.divoi.controller.UsuarioController;
import br.com.divoi.entity.Usuario;
import br.com.divoi.util.StringUtil;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioController usuarioController;   
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Autenticador() {
		super();
		usuarioController = new UsuarioController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
		}
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailLogin");
		String senha = null;
		try {
			senha = StringUtil.SHA1(request.getParameter("senhaLogin"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Usuario usuarioAutenticado = usuarioController.autenticacao(email, senha);

		if(usuarioAutenticado!=null){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}else{
			response.sendRedirect("erroLogin.jsp");
		}
	}

}
