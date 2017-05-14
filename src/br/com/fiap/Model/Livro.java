package br.com.fiap.Model;

public class Livro {

	private int id;
	
	private int codIsbn;
	
	private int paginas;
	
	private int edicao;
	
	private String nomeLivro;
	
	private int autorId;
	
	private int generoId;
	
	private int editoraId;

	/*public Livro(int id, int codIsbn, int paginas, int edicao, String nomeLivro, int autorId, int generoId, int editoraId) {
		super();
		this.id = id;
		this.codIsbn = codIsbn;
		this.paginas = paginas;
		this.edicao = edicao;
		this.nomeLivro = nomeLivro;
		this.autorId = autorId;
		this.generoId = generoId;
		this.editoraId = editoraId;
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodIsbn() {
		return codIsbn;
	}

	public void setCodIsbn(int codIsbn) {
		this.codIsbn = codIsbn;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public int getGeneroId() {
		return generoId;
	}

	public void setGeneroId(int generoId) {
		this.generoId = generoId;
	}

	public int getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(int editoraId) {
		this.editoraId = editoraId;
	}
	
}
