<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.controller.LinguaController"%>
<%@page import="br.com.divoi.entity.Lingua"%>
<%@page import="br.com.divoi.entity.Dialeto"%>
<%@page import="br.com.divoi.controller.DialetoController"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Línguas</title>
<link rel="stylesheet" type="text/css" href="css/tableStyle.css"
	media="screen">
</head>
<body>
<%HttpSession sessao = request.getSession();
	Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado"); 
	if(usuarioAutenticado == null){
	usuarioAutenticado = new Usuario();
	usuarioAutenticado.setTipo("Pesquisador");}
	
	if(usuarioAutenticado.getTipo().equals("Administrador")){ %>
		<jsp:include page="cabecalhoAdm.jsp"></jsp:include>
	<%}else{%>
<jsp:include page="cabecalho.jsp"></jsp:include><%} %>
	<div class="table">
			<%
						DialetoController controller = new DialetoController();
						LinguaController linguaController = new LinguaController();
						String idLingua = request.getParameter("idLingua");
						List<Dialeto> list = controller.getList(Long.parseLong(idLingua));
						Lingua lingua = linguaController.getById(Long.parseLong(idLingua));
						String nomeLingua = lingua.getNome();
						String descricaoLingua = lingua.getDescricao();
						%>
		<div class="table-title">
			<h3><%=nomeLingua %></h3>
			<h2><%=descricaoLingua %></h2>
		</div>
		<table class="table-fill">
			<thead>
				<tr>
					<th class="text-left">Palavra</th>
					<th class="text-left">Tradução</th>
					<th class="text-left">Aplicação numa frase</th>
					<th class="text-left">Tradução da frase</th>
				</tr>
			</thead>
				
			<tbody class="table-hover">
				<%		for (Dialeto dialeto : list) {%>
				<tr>
					<td class="text-center"><a href="listarDialeto.jsp?idDialeto=<%=dialeto.getId()%>"><%=dialeto.getPalavra()%></a></td>
					<td class="text-center"><%=dialeto.getTraducao()%></td>
					<td class="text-center"><%=dialeto.getAplicacaoFrase()%></td>
					<td class="text-center"><%=dialeto.getTraducaoFrase()%></td>
				</tr>
				<%
						}
					%>
			</tbody>
		</table>
		<%if(!usuarioAutenticado.getTipo().equals("Pesquisador")) {%>
		<div id="teste">
			<form action="cadastroDialeto" method="get">
				<input type="hidden" name="idLingua"
					value="<%=idLingua%>" />
				<button class="kc_fab_main_btn" type="submit">+</button>
			</form>
		</div>
		<%} %>
	</div>




</body>
</html>