package br.com.curso.gerenciador.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		 Empresa empresa = banco.buscaById(id);
		 
		 System.out.println(empresa.getNome());
		 
		 req.setAttribute("empresa", empresa);
		 
		 RequestDispatcher rd = req.getRequestDispatcher("/formAlteraEmpresa.jsp");
		 rd.forward(req, res);
	}
}
