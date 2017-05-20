package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

	private Livro livro;
	private LivroDAO dao;
	private List<Livro> carrinhoLivros = new ArrayList<Livro>();

	public CarrinhoMB() {
		livro = new Livro();
		dao = new LivroDAO();
	}

	public List<Livro> getCarrinhoLivros() {
		carrinhoLivros.add(livro);
		return carrinhoLivros;
	}

	public void setCarrinhoLivros(List<Livro> carrinhoLivros) {
		this.carrinhoLivros = carrinhoLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String adcionarCarrinho() {
		livro = dao.pesquisarLivro(livro.getId());
		return "Carrinho";
	}

}
