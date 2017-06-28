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
		<h1>Editar usuário</h1>

		<%
			String idUsuario = request.getParameter("idUsuario");
			UsuarioController controller = new UsuarioController();
			Usuario usuario = controller.getById(Long.parseLong(idUsuario));
		%>

		<form action="editaUsuario" method="post">


			<div class="field-wrap">
				<label> Nome<span class="req">*</span>
				</label> <input type="text" required autocomplete="off" name="nomeUsuario"
					value="<%=usuario.getNome()%>" />
			</div>


			<div class="field-wrap">
				<label> Email<span class="req">*</span>
				</label> <input type="email" required autocomplete="off" name="emailUsuario"
					value="<%=usuario.getEmail()%>" />
			</div>

			<div class="field-wrap">
				<label> Senha<span class="req">*</span>
				</label> <input type="password" required autocomplete="off"
					name="senhaUsuario"
					onchange="form.confirmacaoSenhaUsuario.pattern = this.value;" <%
				if (usuarioAutenticado.getTipo().equals("Administrador")) {%> value="<%=usuario.getSenha()%><%}%>"/>
			</div>

			<div class="field-wrap">
						<label> Confirme a senha<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" name="confirmacaoSenhaUsuario"  onchange="this.setCustomValidity(this.validity.patternMismatch ? 'As senhas não conferem' : '')" <%
				if (usuarioAutenticado.getTipo().equals("Administrador")) {%> value="<%=usuario.getSenha()%><%}%>"/>
					</div>
			
			<input type="hidden" name="idUsuario" value="<%=usuario.getId() %>">

			<%
				if (usuarioAutenticado.getTipo().equals("Administrador")) {%>
			<div class="field-wrap">
				<label> Tipo<span class="req">*</span>
				</label><select name="tipoUsuario">
					<optgroup>
						<option <%if(usuario.getTipo().equals("Pesquisador")) {%> selected <%} %>value="Pesquisador">Pesquisador</option>
						<option <%if(usuario.getTipo().equals("Professor")) {%> selected <%} %>value="Professor">Professor</option>
						<option <%if(usuario.getTipo().equals("Administrador")) {%> selected <%} %>value="Administrador">Administrador</option>
					</optgroup>
				</select>
			</div>
			<%
				}else{%>
					<input type="hidden" name="tipoUsuario" value="<%=usuario.getTipo() %>"><%
				}%>
			<button type="submit" class="button button-block" />
			Editar
			</button>

		</form>
	</div>
</body>
</html>