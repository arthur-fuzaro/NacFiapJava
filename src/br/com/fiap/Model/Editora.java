package br.com.fiap.Model;

public class Editora {

	private int id;
	
	private String nome;
	
	private String nomeFantasia;
	
	private String cpnj;
	
	private String enderešo;
	
	private String email;

	public Editora(int id, String nome, String nomeFantasia, String cpnj, String enderešo, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cpnj = cpnj;
		this.enderešo = enderešo;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getEnderešo() {
		return enderešo;
	}

	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
