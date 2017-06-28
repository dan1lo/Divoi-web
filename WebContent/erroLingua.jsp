<!DOCTYPE html>

<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.entity.Lingua"%>
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

<%
		HttpSession sessao = request.getSession();
		Usuario usuarioAutenticado = (Usuario) sessao.getAttribute("usuarioAutenticado");
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
	
<div class="form">
<h1>Ops! Essa língua já existe.</h1>
</div>

</body>
</html>