package br.com.divoi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.UsuarioController;

/**
 * Servlet implementation class ListaUsuarioGson
 */
@WebServlet("/ListaUsuarioGson")
public class ListaUsuarioGson extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioController usuarioController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUsuarioGson() {
        super();
        usuarioController = new UsuarioController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = usuarioController.getListGson();
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
