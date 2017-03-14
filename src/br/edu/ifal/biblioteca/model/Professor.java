package br.edu.ifal.biblioteca.model;

public class Professor extends Pessoa {
	
	private String formacao;
	
	public String getFormacao () {
		return formacao;
	}
	
	public void setFormacao (String formacao) {
		this.formacao = formacao;
	}
}