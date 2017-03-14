package br.edu.ifal.biblioteca.model;

public class Revista extends Material {
	
	private String isbn;
	private String volume;
	private String edicao;
	
	public String getIsbn () {
		return isbn;
	}
	
	public void setIsbn (String isbn) {
		this.isbn = isbn;
	}
	
	public String getVolume () {
		return volume;
	}
	
	public void setVolume (String volume) {
		this.volume = volume;
	}
	
	public String getEdicao () {
		return edicao;
	}
	
	public void setEdicao (String edicao) {
		this.edicao = edicao;
	}
}