package br.com.curso.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		System.out.println("Logando" + login);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		if (usuario != null) {
			System.out.println("Usuario existe");
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
