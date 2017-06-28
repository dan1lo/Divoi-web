<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.controller.UsuarioController"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuários</title>
<link rel="stylesheet" type="text/css" href="css/tableStyle.css"
	media="screen">
</head>
<body>

<%HttpSession sessao = request.getSession();
Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado"); 
if(usuarioAutenticado.getTipo().equals("Administrador")){ %>
	<jsp:include page="cabecalhoAdm.jsp"></jsp:include>
	<%}%>
	<div class="table">
		<div class="table-title">
			<h3>Usuários cadastrados</h3>
		</div>
		<table class="table-fill">
			<thead>
				<tr>
					<th class="text-left">Nome</th>
					<th class="text-left">Email</th>
					<th class="text-left">Tipo</th>
				</tr>
			</thead>
			<tbody class="table-hover">
				<%
					UsuarioController controller = new UsuarioController();
					List<Usuario> list = controller.getList();
					for (Usuario usuario : list) {
				%>
				<tr>
					<td class="text-center"><a
						href="listarUsuario.jsp?idUsuario=<%=Long.toString(usuario.getId()) %>"><%=usuario.getNome()%></a></td>
					<td class="text-center"><%=usuario.getEmail() %></td>
					<td class="text-center"><%=usuario.getTipo() %></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>