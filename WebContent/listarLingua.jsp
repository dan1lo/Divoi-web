<%@page import="br.com.divoi.entity.Lingua"%>
<%@page import="br.com.divoi.controller.LinguaController"%>
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
	<%
		String idLingua = request.getParameter("idLingua");
		LinguaController controller = new LinguaController();
		UsuarioController usuarioController = new UsuarioController();
		Lingua lingua = controller.getById(Long.parseLong(idLingua));
	%>
	<div class="table-listagem">
		<div class="table-title">
			<h3><%=lingua.getNome() %></h3>
		</div>
		
					<div class="field-wrap">
						<label><p>Nome:<span class="req"><%=lingua.getNome() %></span></p>
						</label>
					</div>


					<div class="field-wrap">
						<label><p>Povo: <span class="req"><%=lingua.getPovo() %></span>
						</label>
					</div>

					<div class="field-wrap">
						<label><p>Localização: <span class="req"><%=lingua.getLocalizacao() %></span></p>
						</label>
					</div>
					
					<div class="field-wrap">
						<label><p>Descrição: <span class="req"><%=lingua.getDescricao() %></span></p>
						</label>
					</div>
					
					
					<div class="field-wrap">
						<label><a href="listarDialetos.jsp?idLingua=<%=lingua.getId()%>"><p id="linkDialeto">Visualizar palavras cadastradas</p></a></label>
						
					</div>
					<%if(!usuarioAutenticado.getTipo().equals("Pesquisador")) {%>
					<div class="botao" id="botaoEditar">
						<a href="editarLingua.jsp?idLingua=<%=Long.toString(lingua.getId())%>">Editar</a>
					</div>
					<div class="botao" id="botaoExcluir">
						<a href="editaLingua?idLingua=<%=Long.toString(lingua.getId())%>">Excluir</a>
					</div>
					<%} %>
	</div>
</body>
</html>