package br.edu.ifal.biblioteca.model;

public abstract class Material {
	
	private String titulo;
	private String editora;
	private int ano;
	
	@Override
	public String toString () {
		return titulo;
	}
	
	public String getTitulo () {
		return titulo;
	}
	
	public void setTitulo (String titulo) {
		this.titulo = titulo;
	}
	
	public String getEditora () {
		return editora;
	}
	
	public void setEditora (String editora) {
		this.editora = editora;
	}
	
	public int getAno () {
		return ano;
	}
	
	public void setAno (int ano) {
		this.ano = ano;
	}
}