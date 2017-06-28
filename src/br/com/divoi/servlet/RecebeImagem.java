package br.com.divoi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.divoi.controller.ArquivoController;
import br.com.divoi.entity.Arquivo;

/**
 * Servlet implementation class RecebeImagem
 */
@WebServlet("/RecebeImagem")
public class RecebeImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArquivoController arquivoController;
	public RecebeImagem() {
		super();
		arquivoController = new ArquivoController();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Arquivo arquivo = new Gson().fromJson(request.getReader(), Arquivo.class);
		
		if(arquivo!= null){
			if(arquivoController.getByIdDialeto(arquivo.getIdDialeto()) == null){
				arquivoController.create(arquivo);
				System.out.println("AQUIII");
			}else{
				Arquivo arquivoAux = arquivoController.getByIdDialeto(arquivo.getIdDialeto());
				arquivoAux.setImagem(arquivo.getImagem());
				if(arquivoAux.getAudio() ==  null){
					arquivoAux.setAudio("none");
				}
				arquivoController.update(arquivoAux);
				System.out.println("AQUI 2222");
			}
		}
	}
}
