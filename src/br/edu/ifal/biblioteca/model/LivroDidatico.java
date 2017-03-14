package br.edu.ifal.biblioteca.model;

public class LivroDidatico extends Livro {
	
	private String disciplina;
	private String serie;
	
	public String getDisciplina () {
		return disciplina;
	}
	
	public void setDisciplina (String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getSerie () {
		return serie;
	}
	
	public void setSerie (String serie) {
		this.serie = serie;
	}
}