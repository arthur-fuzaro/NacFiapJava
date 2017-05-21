package br.com.fiap.Model;

import java.util.HashMap;
import java.util.List;

public class Carrinho {
	
	private Livro livro;
	private Integer quantidade;
	private Double valor;
	private Integer frete = 1;
	
	
	public Integer getFrete() {
		return frete;
	}
	public void setFrete(Integer frete) {
		this.frete = frete;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
