package br.com.fiap.Model;

public class Autor {

	private int Id;
	
	private String FirstName;
	
	private String LastName;

	public Autor(int id, String firstName, String lastName) {
		super();
		this.Id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	
}
