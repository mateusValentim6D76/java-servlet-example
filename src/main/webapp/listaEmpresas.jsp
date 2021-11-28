<%@page import="java.util.List"%>
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.curso.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<html>
<head>
<title>Java Standard Taglib</title>
</head>
<body>
	Lista de empresas: <br />
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> </li>
		</c:forEach>
	</ul>
</body>
</html>