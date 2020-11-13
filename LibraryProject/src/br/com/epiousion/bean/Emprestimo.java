package br.com.epiousion.bean;

public class Emprestimo {
	private int idEmprestimo;
	private String idLivro;
	private String nomeLivro;
	private String idUsuario;
	private String nomeUsuario;
	
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(int idEmprestimo, String idLivro, String nomeLivro, String idUsuario, String nomeUsuario) {
		super();
		this.setIdEmprestimo(idEmprestimo);
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
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
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	
	
	
}
