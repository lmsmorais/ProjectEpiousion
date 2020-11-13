package br.com.epiousion.bean;

public class Usuario {
	private int idUsuario;
	private String nomeUsuario;
	private String senhaUsuario;
	
	public Usuario() {
		
	}
	
	public Usuario(String nomeUsuario, String senhaUsuario)	{
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
