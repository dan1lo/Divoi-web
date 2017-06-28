package br.com.divoi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.divoi.controller.LinguaController;
import br.com.divoi.entity.Lingua;

/**
 * Servlet implementation class RecebeLingua
 */
@WebServlet("/RecebeLingua")
public class RecebeLingua extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LinguaController linguaController;
       
    public RecebeLingua() {
        super();
        linguaController = new LinguaController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Lingua lingua = new Gson().fromJson(request.getReader(), Lingua.class);
		if(lingua!= null){
				linguaController.create(lingua);
		}else{
			System.out.println("Lingua nula");
		}
	}

}
