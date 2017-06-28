package br.com.divoi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.LinguaController;
import br.com.divoi.entity.Lingua;

/**
 * Servlet implementation class CadastroLingua
 */
@WebServlet("/cadastroLingua")
public class CadastroLingua extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinguaController linguaController;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroLingua() {
        super();
        
        linguaController = new LinguaController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String povo = request.getParameter("povo");
		String localizacao = request.getParameter("localizacao");
		String descricao = request.getParameter("descricao");
		
		Lingua lingua = new Lingua(nome,povo,localizacao,descricao);
		
		if(linguaController.create(lingua)){
			response.sendRedirect("listarLinguas.jsp");
		}else{
			response.sendRedirect("erroLingua.jsp");
		}
	}

}
