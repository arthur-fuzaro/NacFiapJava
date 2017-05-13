package br.com.fiap.Model;

public class Editora {

	private int id;
	
	private String nome;
	
	private String nomeFantasia;
	
	private String cpnj;
	
	private String endereço;
	
	private String email;

	public Editora(int id, String nome, String nomeFantasia, String cpnj, String endereço, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cpnj = cpnj;
		this.endereço = endereço;
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
