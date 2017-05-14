package br.com.fiap.Model;

public class Usuario {

	private String login, password, nome;

	public Usuario(String nome, String login, String password) {
		super();
		this.login = login;
		this.password = password;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
}
