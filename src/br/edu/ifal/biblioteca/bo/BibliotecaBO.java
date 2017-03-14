package br.edu.ifal.biblioteca.bo;

import br.edu.ifal.biblioteca.model.Biblioteca;
import br.edu.ifal.biblioteca.model.Locacao;
import br.edu.ifal.biblioteca.model.Material;
import br.edu.ifal.biblioteca.model.Professor;
import br.edu.ifal.biblioteca.util.BibliotecaBOException;

public class BibliotecaBO {
	
	private Biblioteca biblioteca;
	
	public BibliotecaBO (Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public void consultarMateriais () {
		for (Material m: biblioteca.getMateriais()) {
			System.out.println("--- Material ---");
			System.out.println(m.getTitulo());
			System.out.println(m.getEditora());
			System.out.println(m.getAno());
		}
	}
	
	public int getQuantidadeMaterial (Material material) {
		return biblioteca.getQuantidadeMaterial(material);
	}
	
	public void validarCadastroMaterial (Material material, int quantidade) throws BibliotecaBOException {
		if (isMaterialInvalido(material) || quantidade < 1) {
			throw new BibliotecaBOException("Cadastro inválido");
		} else {
			biblioteca.cadastrarMaterial(material, quantidade);
		}
	}
	
	public void adicionarLocacao (Locacao locacao) throws BibliotecaBOException {
		try {
			biblioteca.adicionarLocacao(locacao);
			
			if (locacao.getPessoa() instanceof Professor)
				System.out.println("04 dias para cada material locado.");
			else
				System.out.println("02 dias para cada material locado.");
		} catch (Exception e) {
			throw new BibliotecaBOException(e.getMessage());
		}
	}
	
	public boolean isMaterialInvalido (Material material) {
		if (material.getTitulo().equals("") 
		 || !isTituloValido(material.getTitulo())
		 || material.getEditora().equals("") 
		 || material.getAno() == 0)
			return true;
		return false;
	}
	
	public boolean isTituloValido (String titulo) {
		if (titulo.length() >= 4 && titulo.length() <= 35)
			return true;
		return false;
	}
}