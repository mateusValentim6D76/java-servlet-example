<%@page import="java.util.List"%>
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.curso.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title>Java Standard Taglib</title>
</head>
<body>
	Lista de empresas: <br />
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome}</li>
		</c:forEach>
	</ul>
</body>
</html>