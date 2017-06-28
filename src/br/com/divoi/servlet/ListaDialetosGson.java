package br.com.divoi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.DialetoController;

@WebServlet("/ListaDialetosGson")
public class ListaDialetosGson extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DialetoController dialetoController;
	
    public ListaDialetosGson() {
    	dialetoController = new DialetoController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json = dialetoController.getListGson(Long.parseLong(request.getParameter("idLingua")));
		response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
