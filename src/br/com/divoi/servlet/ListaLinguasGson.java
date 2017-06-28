package br.com.divoi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.LinguaController;

@WebServlet("/ListaLinguasGson")
public class ListaLinguasGson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LinguaController linguaController;

    public ListaLinguasGson() {
        linguaController = new LinguaController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String json = linguaController.getListGson();
		 response.getWriter().append(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
