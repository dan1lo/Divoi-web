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

@WebServlet("/CadastroUsuario")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioController usuarioController;

	public CadastroUsuario() {
		super();
		usuarioController = new UsuarioController();

	}


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeUsuario");
		String email = request.getParameter("emailUsuario");
		String senha = "";
		try {
			senha = StringUtil.SHA1(request.getParameter("senhaUsuario"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tipo = "Pesquisador";

		Usuario usuario = new Usuario(nome,email,senha,tipo);
		if(usuarioController.create(usuario)){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioAutenticado", usuario);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		

	}

}




