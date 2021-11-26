<%@page import="java.util.List"%>
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.curso.gerenciador.servlet.Empresa"%>

<html>
<body>
	<ul>
		<%
		List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
		for (Empresa empresa : lista) {
		%>
		<li><%=empresa.getNome()%></li>
		<%
		}
		%>
	</ul>
</body>
</html>