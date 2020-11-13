package br.com.epiousion.bean;

public class Livro {
	
	private String idLivro;
	private String nomeLivro;
	
	public Livro() {

	}
	
	public Livro(String idLivro, String nomeLivro) {
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
	}

	public String getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	
	
	
}
