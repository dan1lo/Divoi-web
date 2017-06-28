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
 * Servlet implementation class EditaLingua
 */
@WebServlet("/editaLingua")
public class EditaLingua extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinguaController linguaController;
    public EditaLingua() {
        super();
        linguaController = new LinguaController();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idLingua");
		if(id!=null){
			if(linguaController.delete(Long.parseLong(id))){
				response.sendRedirect("listarLinguas.jsp");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idLingua = request.getParameter("idLingua");
		String nome = request.getParameter("nome");
		String povo = request.getParameter("povo");
		String localizacao = request.getParameter("localizacao");
		String descricao = request.getParameter("descricao");
		
		Lingua lingua = new Lingua(Long.parseLong(idLingua),nome,povo,localizacao,descricao);
		if(linguaController.update(lingua)){
			response.sendRedirect("listarLingua.jsp?idLingua="+idLingua);
		}
	}

}
