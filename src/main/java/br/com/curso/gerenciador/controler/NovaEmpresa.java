package br.com.curso.gerenciador.controler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Empresa;

public class NovaEmpresa {

	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("acao Cadastrando nova empresa");

		String nomeEmpresa = req.getParameter("nome");
		String paramDataEmpresa = req.getParameter("data");

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		Banco banco = new Banco();
		banco.adiciona(empresa);

		req.setAttribute("empresa", empresa.getNome());

		res.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
