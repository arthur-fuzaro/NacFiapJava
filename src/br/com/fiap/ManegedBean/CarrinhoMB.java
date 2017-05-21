package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Carrinho;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class CarrinhoMB {

	private Livro livro;
	private LivroDAO dao;
	//private List<Livro> carrinhoLivros = new ArrayList();
	private double totalCarrinho;
	
	private List<Carrinho> carrinho = new ArrayList<Carrinho>();

	public double getTotalCarrinho() {
		return totalCarrinho;
	}

	public void setTotalCarrinho(double totalCarrinho) {
		this.totalCarrinho = totalCarrinho;
	}

	public CarrinhoMB() {
		livro = new Livro();
		dao = new LivroDAO();
	}

	public List<Carrinho> getCarrinho() {
		//carrinhoLivros.add(livro);
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinhoLivros) {
		this.carrinho = carrinhoLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String adcionarCarrinho() {
		livro = dao.pesquisarLivro(livro.getId());
		Carrinho carrinhoModal = new Carrinho();
		carrinhoModal.setLivro(livro);
		carrinhoModal.setQuantidade(1);
		carrinhoModal.setValor(livro.getPreco());
		carrinho.add(carrinhoModal);
		totalCarrinho();
		return "Carrinho";
	}
	
	public int getQuantCarrinho(){
		return carrinho.size();
	}
	
	public List<String> getTotalValor(){
		List<String> total = new ArrayList<String>();
		
		return total;
	}
	
	public String atualizarCarrinho(){
		
		for (int i = 0; i < getQuantCarrinho(); i++) {
			Carrinho carrinho2 = carrinho.get(i);
			if(carrinho2.getQuantidade()==0){
				carrinho.remove(i);
			}else{
				carrinho2.setValor(carrinho2.getLivro().getPreco() * carrinho2.getQuantidade());
			}
		}
		totalCarrinho();
		
		
		
		return "Carrinho";
	}
	
	public void totalCarrinho(){
		setTotalCarrinho(0);
		for (Carrinho carrinho2 : carrinho) {
			setTotalCarrinho(getTotalCarrinho() + carrinho2.getValor());
		}
	}
	
	public Double getCalculaFrete(){
		double valorFrete = 0;
		Carrinho c = new Carrinho();
		switch(c.getFrete()){
		case 1:
			valorFrete = 10;
			break;
		case 2:
			valorFrete = 20;
			break;
		}
		return valorFrete+getTotalCarrinho();
	}
	
}
