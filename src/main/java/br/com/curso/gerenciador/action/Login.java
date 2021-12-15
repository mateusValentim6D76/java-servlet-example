package br.com.curso.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		System.out.println("Logando" + login);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
	}

}
