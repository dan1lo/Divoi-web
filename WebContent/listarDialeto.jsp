<%@page import="br.com.divoi.entity.Arquivo"%>
<%@page import="br.com.divoi.controller.ArquivoController"%>
<%@page import="br.com.divoi.entity.Dialeto"%>
<%@page import="br.com.divoi.controller.DialetoController"%>
<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.controller.UsuarioController"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Divoi</title>
<link rel="stylesheet" type="text/css" href="css/teste.css"
	media="screen">
<link rel="stylesheet" type="text/css" href="css/tableStyle.css"
	media="screen">
<META HTTP-EQUIV="EXPIRES" CONTENT="0">
<META HTTP-EQUIV="pragma" CONTENT="nocache">
</head>
<body>

	<%
		HttpSession sessao = request.getSession();
		Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado");
		if (usuarioAutenticado == null) {
			usuarioAutenticado = new Usuario();
			usuarioAutenticado.setTipo("Pesquisador");
		}

		if (usuarioAutenticado.getTipo().equals("Administrador")) {
	%>
	<jsp:include page="cabecalhoAdm.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<%
		}
	%>
	<%
		String idDialeto = request.getParameter("idDialeto");
		DialetoController controller = new DialetoController();
		Dialeto dialeto = controller.getById(Long.parseLong(idDialeto));
	%>
	<div class="table-listagem">
		<div class="table-title">
			<h3><%=dialeto.getPalavra()%></h3>
		</div>


		<%
			ArquivoController ac = new ArquivoController();
			Arquivo arquivo = ac.getByIdDialeto(dialeto.getId());
			if (arquivo != null) {
				if (arquivo.getImagem() != null) {
		%>

		<img id="imagem" class="imagem" src="<%=arquivo.getImagem()%>"
			alt="mostrar imagem" width=200 height=200>
		<%
			}
				if (arquivo.getAudio() != null) {
		%>
		<audio controls class="audio"> <source
			src="<%=arquivo.getAudio()%>" type="audio/mp3"></audio>
		<%
			}
			}
		%>
		<a id="imagemLink"
			href="gravarArquivo.jsp?idDialeto=<%=dialeto.getId()%>">Inserir
			imagem</a> <a id="audioLink"
			href="gravarAudio.jsp?idDialeto=<%=dialeto.getId()%>">Inserir
			áudio</a>
		<div class="field-wrap">
			<label><p>
					Palavra:<span class="req"><%=dialeto.getPalavra()%></span>
				</p> </label>
		</div>

		<div class="field-wrap">
			<label><p>
					Tradução: <span class="req"><%=dialeto.getTraducao()%></span></label>
		</div>

		<div class="field-wrap">
			<label><p>
					Aplicação numa frase: <span class="req"><%=dialeto.getAplicacaoFrase()%></span>
				</p> </label>
		</div>

		<div class="field-wrap">
			<label><p>
					Tradução da frase: <span class="req"><%=dialeto.getTraducaoFrase()%></span>
				</p> </label>
		</div>

		<div class="field-wrap">
			<label><p>
					Língua: <span class="req"><%=dialeto.getLingua().getNome()%></span>
				</p> </label>
		</div>



		<%
			if (!usuarioAutenticado.getTipo().equals("Pesquisador")) {
		%>
		<div class="botao" id="botaoEditar">
			<a
				href="editarDialeto.jsp?idDialeto=<%=Long.toString(dialeto.getId())%>">Editar</a>
		</div>
		<div class="botao" id="botaoExcluir">
			<a
				href="editaDialeto?idDialeto=<%=Long.toString(dialeto.getId())%>&idLingua=<%=Long.toString(dialeto.getLingua().getId())%>">Excluir</a>
		</div>
		<%
			}
		%>
	</div>

</body>
</html>