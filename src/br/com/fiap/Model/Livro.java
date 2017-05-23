package br.com.fiap.Model;

public class Livro {

	private Integer id;
	private Integer codIsbn;
	private Integer paginas;
	private Integer edicao;
	private String nomeLivro;
	private Integer autorId;
	private Integer generoId;
	private Integer editoraId;
	private Double preco;
	private Integer qtd;
	private Double totalValor;
	private double desconto;

	public double getDesconto() {
		return desconto;
	}	
	
	public double getDescontoConta() {
		double preco = this.getPreco();
		double desconto = this.desconto;
		desconto = preco - ((desconto/100.0) * preco);
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double getTotalValor() {
		return totalValor;
	}

	public void setTotalValor(Double totalValor) {
		this.totalValor = totalValor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodIsbn() {
		return codIsbn;
	}

	public void setCodIsbn(Integer codIsbn) {
		this.codIsbn = codIsbn;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Integer getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Integer generoId) {
		this.generoId = generoId;
	}

	public Integer getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
