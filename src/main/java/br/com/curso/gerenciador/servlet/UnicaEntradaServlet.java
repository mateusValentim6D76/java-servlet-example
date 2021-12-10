package br.com.curso.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.controler.ListaEmpresas;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {
			System.out.println("Listando empresas");
			
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			listaEmpresas.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresas")) {
			System.out.println("Removendo empresa");
		}else if (paramAcao.equals("MostraEmpresa")) {
			System.out.println("Exibindo empresa");
		}
	}
}
