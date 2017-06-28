<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.entity.Lingua"%>
<%@page import="java.util.List"%>
<%@page import="br.com.divoi.controller.LinguaController"%>
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
		<div class="table-title">
			<h3>Línguas cadastradas</h3>
		</div>
		<table class="table-fill">
			<thead>
				<tr>
					<th class="text-left">Nome da língua</th>
					<th class="text-left">Povo</th>
					<th class="text-left">Localizacao</th>
					<th class="text-left">Palavras</th>
				</tr>
			</thead>
			<tbody class="table-hover">
				<%
					LinguaController controller = new LinguaController();
					List<Lingua> list = controller.getList();
					for (Lingua lingua : list) {
						//html += "<li>" + usuario.getNome();
				%>
				<tr>
					<td class="text-center"><a
						href="listarLingua.jsp?idLingua=<%=Long.toString(lingua.getId())%>"><%=lingua.getNome()%></a></td>
					<td class="text-center"><%=lingua.getPovo()%></td>
					<td class="text-center"><%=lingua.getLocalizacao()%></td>
					<td class="text-center"><a href="listarDialetos.jsp?idLingua=<%=lingua.getId()%>">Visualizar palavras cadastradas</a>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<%if(!usuarioAutenticado.getTipo().equals("Pesquisador")) {%>
	<div id="teste">
			<form action="cadastrarLingua.jsp"">
				<button class="kc_fab_main_btn" type="submit">+</button>
			</form>
		</div>
		<%} %>
</body>
</html>