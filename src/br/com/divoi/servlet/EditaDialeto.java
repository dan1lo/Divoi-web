package br.com.divoi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.DialetoController;
import br.com.divoi.controller.LinguaController;
import br.com.divoi.entity.Dialeto;
import br.com.divoi.entity.Lingua;


@WebServlet("/editaDialeto")
public class EditaDialeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DialetoController dialetoController;
	private LinguaController linguaController;
	
    public EditaDialeto() {
        super();
        dialetoController = new DialetoController();
		linguaController = new LinguaController();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idDialeto");
		String idLingua = request.getParameter("idLingua");
		if(id!=null){
			if(dialetoController.delete(Long.parseLong(id))){
				response.sendRedirect("listarDialetos.jsp?idLingua="+idLingua);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idLingua = request.getParameter("idLingua");
		String idDialeto = request.getParameter("idDialeto");
		String palavra = request.getParameter("palavra");
		String traducao = request.getParameter("traducao");
		String aplicacaoFrase = request.getParameter("aplicacaoFrase");
		String traducaoAplicacaoFrase = request.getParameter("traducaoAplicacaoFrase");
		Lingua lingua = linguaController.getById(Long.parseLong(idLingua));
		Dialeto dialeto = new Dialeto(Long.parseLong(idDialeto),palavra,traducao,aplicacaoFrase,traducaoAplicacaoFrase,lingua);
		if(dialetoController.update(dialeto)){
			response.sendRedirect("listarDialeto.jsp?idDialeto="+idDialeto);
		}
	}

}
