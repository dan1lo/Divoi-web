package br.com.divoi.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.divoi.controller.DialetoController;
import br.com.divoi.controller.LinguaController;
import br.com.divoi.entity.Dialeto;
import br.com.divoi.entity.Lingua;


@WebServlet("/cadastroDialeto")
public class CadastroDialeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DialetoController dialetoController;
	private LinguaController linguaController;

	public CadastroDialeto() {
		super();
		dialetoController = new DialetoController();
		linguaController = new LinguaController();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idLingua");
		if(id!=null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarDialetos.jsp");
			request.setAttribute("idLingua", id);
			dispatcher.forward(request, response);

		}
		System.out.println("T� aqui");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palavra = request.getParameter("palavra");
		String traducao = request.getParameter("traducao");
		String aplicacaoFrase = request.getParameter("aplicacaoFrase");
		String traducaoAplicacaoFrase = request.getParameter("traducaoAplicacaoFrase");
		String idLingua = request.getParameter("idLingua");
		Lingua lingua = linguaController.getById(Long.parseLong(idLingua));

		Dialeto dialeto = new Dialeto(palavra,traducao,aplicacaoFrase,traducaoAplicacaoFrase,lingua);
		if(dialetoController.create(dialeto)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("listarDialetos.jsp");
			request.setAttribute("idLingua", idLingua);
			dispatcher.forward(request, response);
		}

	}

}
