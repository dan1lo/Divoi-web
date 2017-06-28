package br.com.divoi.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.UsuarioController;
import br.com.divoi.entity.Usuario;
import br.com.divoi.util.StringUtil;


@WebServlet("/editaUsuario")
public class EditaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioController usuarioController;

    public EditaUsuario() {
        super();
        usuarioController = new UsuarioController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idUsuario");
		if(id!=null){
			if(usuarioController.delete(Long.parseLong(id))){
				response.sendRedirect("login.html");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idUsuario");
		String nome = request.getParameter("nomeUsuario");
		String email = request.getParameter("emailUsuario");
		String senha = null;
		try {
			senha = StringUtil.SHA1(request.getParameter("senhaUsuario"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tipo = request.getParameter("tipoUsuario");
		
		Usuario usuario = new Usuario(Long.parseLong(id),nome,email,senha,tipo);
		if(usuarioController.update(usuario)){
			response.sendRedirect("listarUsuario.jsp?idUsuario="+id);
		}
	}

}
