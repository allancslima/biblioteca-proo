package br.edu.ifal.biblioteca.model;

public class Aluno extends Pessoa {
	
	private int matricula;
	private String serie;
	
	public int getMatricula () {
		return matricula;
	}
	
	public void setMatricula (int matricula) {
		this.matricula = matricula;
	}
	
	public String getSerie () {
		return serie;
	}
	
	public void setSerie (String serie) {
		this.serie = serie;
	}
}