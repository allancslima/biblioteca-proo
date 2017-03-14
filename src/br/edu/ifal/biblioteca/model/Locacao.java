package br.edu.ifal.biblioteca.model;

public class Locacao {
	
	private Material material;
	private Pessoa pessoa;
	
	public Material getMaterial () {
		return material;
	}
	
	public void setMaterial (Material material) {
		this.material = material;
	}
	
	public Pessoa getPessoa () {
		return pessoa;
	}
	
	public void setPessoa (Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}