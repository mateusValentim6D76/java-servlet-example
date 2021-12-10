package br.com.curso.gerenciador.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Empresa;

public class ListaEmpresas {

	protected void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Banco banco = new Banco();
			List<Empresa> listaEmpresas = banco.getEmpresa();

			request.setAttribute("empresas", listaEmpresas);

			RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
			rd.forward(request, response);
	}
}
