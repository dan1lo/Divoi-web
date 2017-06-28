package br.com.divoi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.divoi.controller.DialetoController;
import br.com.divoi.entity.Dialeto;

@WebServlet("/RecebePalavra")
public class RecebePalavra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DialetoController palavraController;
       
    public RecebePalavra() {
        super();
        palavraController = new DialetoController();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dialeto palavra = new Gson().fromJson(request.getReader(), Dialeto.class);
		if(palavra != null){
				palavraController.create(palavra);
		}else{
			System.out.println("Lingua nula");
		}
	}

}
