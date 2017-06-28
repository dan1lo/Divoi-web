package br.com.divoi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.ArquivoController;
import br.com.divoi.entity.Arquivo;

@WebServlet("/UploadAudio")
public class UploadAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;



	private ArquivoController arquivoController;
	public UploadAudio() {
		super();
		arquivoController = new ArquivoController();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idDialeto = Long.parseLong(request.getParameter("idDialeto"));
		String downloadLink = String.valueOf(request.getParameter("downloadUrl"));
		Arquivo arquivo = null;

		if(arquivoController.getByIdDialeto(idDialeto) == null){
			arquivo = new Arquivo();
			arquivo.setIdDialeto(idDialeto);
			arquivo.setAudio(downloadLink);
			arquivoController.create(arquivo);
			response.sendRedirect("listarDialeto.jsp?idDialeto="+idDialeto);
		}else{
			arquivo = arquivoController.getByIdDialeto(idDialeto);
			arquivo.setAudio(downloadLink);
			arquivoController.update(arquivo);
			response.sendRedirect("listarDialeto.jsp?idDialeto="+idDialeto);
		}
	}

}
