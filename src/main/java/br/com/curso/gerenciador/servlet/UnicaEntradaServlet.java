package br.com.curso.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.action.AlteraEmpresa;
import br.com.curso.gerenciador.action.ListaEmpresas;
import br.com.curso.gerenciador.action.MostraEmpresa;
import br.com.curso.gerenciador.action.NovaEmpresa;
import br.com.curso.gerenciador.action.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {

			ListaEmpresas listaEmpresas = new ListaEmpresas();
			listaEmpresas.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresas")) {

			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			removeEmpresa.executa(request, response);

		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			mostraEmpresa.executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			alteraEmpresa.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			novaEmpresa.executa(request, response);
		}
	}
}
