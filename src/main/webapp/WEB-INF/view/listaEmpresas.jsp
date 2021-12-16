<%@page import="java.util.List"%>
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.curso.gerenciador.model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	Usuario logado: ${usuarioLogado.login }
	<br>
	<br>

	<c:if test="${not empty empresa}">
	Empresa ${empresa} cadastrada com sucesso!
	</c:if>

	<br>Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />
			</li>
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
			<a href="/gerenciador/entrada?acao=RemoveEmpresas&id=${empresa.id}">Remover</a>
		</c:forEach>
	</ul>
</body>
</html>