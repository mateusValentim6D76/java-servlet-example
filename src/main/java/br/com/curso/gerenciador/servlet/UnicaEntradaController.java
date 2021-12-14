package br.com.curso.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.action.Acao;
import br.com.curso.gerenciador.action.AlteraEmpresa;
import br.com.curso.gerenciador.action.ListaEmpresas;
import br.com.curso.gerenciador.action.MostraEmpresa;
import br.com.curso.gerenciador.action.NovaEmpresa;
import br.com.curso.gerenciador.action.NovaEmpresaForm;
import br.com.curso.gerenciador.action.RemoveEmpresas;

@WebServlet("/entrada")
public class UnicaEntradaController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");

		String nomeDaClasse = "br.com.curso.gerenciador.action." + paramAcao;

		String nome;

		try {
			Class classe = Class.forName(nomeDaClasse); // Carrega o pacote e Classe
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipo_Endereco = nome.split(":");
		if (tipo_Endereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipo_Endereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipo_Endereco[1]);
		}
//		if (paramAcao.equals("ListaEmpresas")) {
//			
//						ListaEmpresas listaEmpresas = new ListaEmpresas();
//						nome = listaEmpresas.executa(request, response);
//					} else if (paramAcao.equals("RemoveEmpresas")) {
//						RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//						nome = removeEmpresa.executa(request, response);
//					} else if (paramAcao.equals("MostraEmpresa")) {
//						MostraEmpresa mostraEmpresa = new MostraEmpresa();
//						nome = mostraEmpresa.executa(request, response);
//					} else if (paramAcao.equals("AlteraEmpresa")) {
//						AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//						nome = alteraEmpresa.executa(request, response);
//					} else if (paramAcao.equals("NovaEmpresa")) {
//						NovaEmpresa novaEmpresa = new NovaEmpresa();
//						nome = novaEmpresa.executa(request, response);
//					}else if (paramAcao.equals("NovaEmpresaForm")) {
//						NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
//						nome = novaEmpresaForm.executa(request, response);
//					}
		}

	}

