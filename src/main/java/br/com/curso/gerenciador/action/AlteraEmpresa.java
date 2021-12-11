package br.com.curso.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Empresa;

public class AlteraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println("acao Alterando empresa" + id);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	
		Banco banco = new Banco();
		Empresa empresa = banco.buscaById(id);
		empresa.setNome(nomeEmpresa); 
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
