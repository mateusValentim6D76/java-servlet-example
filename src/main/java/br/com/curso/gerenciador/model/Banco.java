package br.com.curso.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresa = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		Banco.listaEmpresa.add(empresa);
		Banco.listaEmpresa.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("mateus");
		u1.setSenha("1234");
		
		Usuario u2 = new Usuario();
		u2.setLogin("helena");
		u2.setSenha("1234");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		listaEmpresa.add(empresa);
	}

	public List<Empresa> getEmpresa() {
		return Banco.listaEmpresa;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresa.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaById(Integer id) {
		for (Empresa empresa : listaEmpresa) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
	    for(Usuario user : listaUsuarios) {
	        if(user.eIgual(login, senha)) { 
	            return user;
	        }
	    }
	    return null;
	}
}
