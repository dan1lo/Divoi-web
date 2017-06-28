<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.entity.Lingua"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		<h1>Cadastrar Palavra</h1>

		<form method="post" action="cadastroDialeto" id="formDialeto" >

			<div class="field-wrap">
				<label> Palavra:<span class="req">*</span>
				</label> <input type="text" required="required" name="palavra" /><br />
			</div>

			<div class="field-wrap">
				<label> Tradução:<span class="req">*</span>
				</label> <input type="text" required="required" name="traducao" /><br />
			</div>

			<div class="field-wrap">
				<label> Aplicação numa frase:<span class="req">*</span>
				</label> <input type="text" required="required" name="aplicacaoFrase" /><br />
			</div>
			<div class="field-wrap">
				<label> Tradução da frase:<span class="req">*</span>
				</label> <input type="text" required="required"
					name="traducaoAplicacaoFrase" /><br />
			</div>

			<input type="hidden" name="idLingua"
				value="<%=request.getAttribute("idLingua")%>">
		</form>
		
		

		<button class="button button-block" type="submit" form="formDialeto" />
		Cadastrar palavra
		</button>




	</div>
</body>
</html>