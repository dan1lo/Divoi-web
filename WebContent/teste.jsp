<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="">
senha: <input type="password" name="pwd1" onchange="form.pwd2.pattern = this.value;">
<br />
repita a senha: <input type="password" name="pwd2" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'As senhas não conferem' : '')"></p>
<input type="submit">
</form>
</body>
</html>