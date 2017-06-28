<%@page import="br.com.divoi.entity.Lingua"%>
<%@page import="br.com.divoi.controller.LinguaController"%>
<%@page import="br.com.divoi.entity.Usuario"%>
<%@page import="br.com.divoi.controller.UsuarioController"%>
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
		<h1>Editar língua</h1>

		<%
		String idLingua = request.getParameter("idLingua");
		LinguaController controller = new LinguaController();
		UsuarioController usuarioController = new UsuarioController();
		Lingua lingua = controller.getById(Long.parseLong(idLingua));
		%>

		<form action="editaLingua" method="post" id="formLingua">
		
			<div class="field-wrap">
				<label> Nome da língua:<span class="req">*</span>
				</label> <input type="text" required="required" name="nome" value="<%=lingua.getNome()%>"/><br />
			</div>

			<div class="field-wrap">
				<label> Povo:<span class="req">*</span>
				</label> <input type="text" required="required" name="povo"  value="<%=lingua.getPovo()%>"/><br />
			</div>

			<div class="field-wrap">
				<label> Localizacao:<span class="req">*</span>
				</label> <input type="text" required="required" name="localizacao" value="<%=lingua.getLocalizacao()%>"/><br />
			</div>
			
			<input type="hidden" name="idLingua" value="<%=Long.toString(lingua.getId()) %>">


		</form>

		<div class="field-wrap">
			<label> Descrição:<span class="req">*</span>
			</label>
			<textarea rows="10" cols="50" name="descricao" required="required" form="formLingua" ><%=lingua.getDescricao() %></textarea>
		</div>
			<button type="submit" class="button button-block" form="formLingua"/>
			Editar
			</button>

		</form>
	</div>
</body>
</html>