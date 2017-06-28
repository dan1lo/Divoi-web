<%@page import="br.com.divoi.entity.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Língua indígena</title>
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

	
	<div class="form">
		<h1>Cadastrar Língua indígena</h1>

		<form method="post" action="cadastroLingua" id="formLingua">

			<div class="field-wrap">
				<label> Nome da língua:<span class="req">*</span>
				</label> <input type="text" required="required" name="nome" /><br />
			</div>

			<div class="field-wrap">
				<label> Povo:<span class="req">*</span>
				</label> <input type="text" required="required" name="povo" /><br />
			</div>

			<div class="field-wrap">
				<label> Localizacao:<span class="req">*</span>
				</label> <input type="text" required="required" name="localizacao" /><br />
			</div>


		</form>

		<div class="field-wrap">
			<label> Descrição:<span class="req">*</span>
			</label>
			<textarea rows="10" cols="50" name="descricao" required="required" form="formLingua"></textarea>
		</div>

		<button class="button button-block" type="submit" form="formLingua" />
		Cadastrar língua
		</button>




	</div>

</body>
</html>