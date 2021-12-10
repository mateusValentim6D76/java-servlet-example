package br.com.curso.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Empresa;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("Alterando empresa");

		
		String nomeEmpresa = req.getParameter("nome");
		String paramDataEmpresa = req.getParameter("data");
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

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
		
		res.sendRedirect("listaEmpresas");
		
	}
	                                                                                       
}

