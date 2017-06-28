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
 * Servlet implementation class RecebeArquivo
 */
@WebServlet("/RecebeArquivo")
public class RecebeArquivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private ArquivoController arquivoController;
    public RecebeArquivo() {
        super();
        // TODO Auto-generated constructor stub
        arquivoController = new ArquivoController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Arquivo arquivo = new Gson().fromJson(request.getReader(), Arquivo.class);
		if(arquivo!= null){
			if(arquivoController.getByIdDialeto(arquivo.getIdDialeto()) == null){
				arquivoController.create(arquivo);
				System.out.println("AQUIII");
			}else{
				Arquivo arquivoAux = arquivoController.getByIdDialeto(arquivo.getIdDialeto());
				arquivoAux.setAudio(arquivo.getAudio());
				if(arquivoAux.getImagem() == null){
					arquivoAux.setImagem("none");
				}
				arquivoController.update(arquivoAux);
				System.out.println("AQUI 2222");
			}
		}
	}

}
