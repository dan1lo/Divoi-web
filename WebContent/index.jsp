
<%@page import="java.util.List"%>

<%@page import="br.com.divoi.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Divoi</title>
<script>
Cache:rememberForever('js_version_number', time());</script>
<link rel="stylesheet" type="text/css" href="css/teste.css?v={{ Cache::get('js_version_number') }}"
	media="screen">
<link rel="stylesheet" type="text/css" href="css/tableStyle.css"
	media="screen">
	<style>
		#conteudo {
				display: flex;
				min-height: 100vh;
				width: 100%;
				paddin: 0;
				margin: 0;
				align-items: center;
				
				flex-direction: column;
			}	
	</style>
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
	<div id="conteudo">
	<h1 class="home">Dicionário de vocábulos indígenas</h1>
	<h1 class="home">Cadastre uma língua indígena,
		pesquise, aprenda!</h1>
		<img alt="Divoi" src="UploadedFiles/divoi.png">
</div>
		
</body>
</html>