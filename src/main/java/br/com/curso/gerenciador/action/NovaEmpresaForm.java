package br.com.curso.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.model.Banco;
import br.com.curso.gerenciador.model.Empresa;

public class NovaEmpresaForm implements Acao{

	public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		return "forward:formNovaEmpresa.jsp";
	}
}
