package br.com.curso.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listando empresas");

		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresa();
		
		request.setAttribute("empresas", listaEmpresas);

		return "forward:listaEmpresas.jsp";
	}
}
