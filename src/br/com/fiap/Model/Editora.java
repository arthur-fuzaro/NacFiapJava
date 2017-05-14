package br.com.fiap.Model;

public class Editora {

	private int Id;
	
	private String Nome;
	
	private String NomeFantasia;
	
	private String Cpnj;
	
	private String Endereço;
	
	private String Email;

	public Editora(int id, String nome, String nomeFantasia, String cpnj, String endereço, String email) {
		super();
		this.Id = id;
		Nome = nome;
		NomeFantasia = nomeFantasia;
		Cpnj = cpnj;
		Endereço = endereço;
		Email = email;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getNomeFantasia() {
		return NomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}

	public String getCpnj() {
		return Cpnj;
	}

	public void setCpnj(String cpnj) {
		Cpnj = cpnj;
	}

	public String getEndereço() {
		return Endereço;
	}

	public void setEndereço(String endereço) {
		Endereço = endereço;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
