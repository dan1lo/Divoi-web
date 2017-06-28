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
if(usuarioAutenticado.getTipo().equals("Administrador")){ %>
	<jsp:include page="cabecalhoAdm.jsp"></jsp:include>
	<%}else{%>
<jsp:include page="cabecalho.jsp"></jsp:include><%} %>
	<%
		String idUsuario = request.getParameter("idUsuario");
		UsuarioController controller = new UsuarioController();
		Usuario usuario = controller.getById(Long.parseLong(idUsuario));	
	%>
	<div class="table-listagem">
		<div class="table-title">
			<h3><%=usuario.getNome() %></h3>
		</div>
		
					<div class="field-wrap">
						<label><p>Nome:<span class="req"><%=usuario.getNome() %></span></p>
						</label>
					</div>


					<div class="field-wrap">
						<label><p>Email: <span class="req"><%=usuario.getEmail() %></span>
						</label>
					</div>
					
					<div class="botao" id="botaoEditar">
						<a href="editarUsuario.jsp?idUsuario=<%=Long.toString(usuario.getId())%>">Editar</a>
					</div>
					<div class="botao" id="botaoExcluir">
						<a href="editaUsuario?idUsuario=<%=Long.toString(usuario.getId())%>">Excluir</a>
					</div>
	</div>
</body>
</html>