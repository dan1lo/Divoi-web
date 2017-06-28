<%@page import="br.com.divoi.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css" media="screen">
</head>
<body>
<%HttpSession sessao = request.getSession();
Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado"); 
if(usuarioAutenticado != null){%>

	<div id="navegacao">
		<nav id="menu">
			<ul id="nav">
				<li class="selected"><a href="index.jsp">Página inicial</a></li>
				<li class="selected"><a href="listarLinguas.jsp">Línguas</a>
				<li class="selected"><a href="listarUsuario.jsp?idUsuario=<%=Long.toString(usuarioAutenticado.getId()) %>">Configurações da conta</a></li>
				<li class="selected"><a href="Autenticador">Sair</a></li>
			</ul>
		</nav>
	</div>
	<%}else{ %>
		
		<div id="navegacao">
		<nav id="menu">
			<ul id="nav">
				<li class="selected"><a href="index.jsp">Página inicial</a></li>
				<li class="selected"><a href="listarLinguas.jsp">Línguas</a>
				<li class="selected"><a href="Autenticador">Fazer login</a></li>
			</ul>
		</nav>
	</div>
	<%} %>

</body>
</html>