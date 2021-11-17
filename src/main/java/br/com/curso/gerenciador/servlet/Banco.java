package br.com.curso.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	static {
		  Empresa empresa = new Empresa();
		  empresa.setNome("Alura");
		  Empresa empresa2 = new Empresa();
		  empresa2.setNome("Caelum");
		  Banco.lista.add(empresa);
		  Banco.lista.add(empresa2);
		}
	
	private static List<Empresa> lista = new ArrayList();
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.lista;
	}
}
