package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class GeralMB {

	
	private static String sucesso;
	private static String erro;
	private Livro livro;
	private List<Livro> listaDesejos;

	public GeralMB(){
		livro = new Livro();
		listaDesejos = new ArrayList<Livro>();
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		GeralMB.erro = erro;
	}

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		GeralMB.sucesso = sucesso;
	}
	
	public String abrirCadastroLivros(){
		return "Cadastro_livro";
	}
	
	public String abrirCadastroGeneros(){
		return "Cadastro_Genero";
	}
	
	public String abrirCadastroEditoras(){
		return "Cadastro_editora";
	}
	
	public String abrirCadastroAutores(){
		return "Cadastro_Autor";
	}
	
	public String abrirCadastroUsuarios(){
		return "Cadastro_Usuario";
	}
	
	public String abrirCarrinho(){
		return "Carrinho";
	}

	public List<Livro> getListaDesejos() {
		return listaDesejos;
	}

	public void setListaDesejos(List<Livro> listaDesejos) {
		this.listaDesejos = listaDesejos;
	}
	
	public String adicionarListaDeDesejos(){
		LivroDAO dao = new LivroDAO();
		livro = dao.pesquisarLivro(livro.getId());
		listaDesejos.add(livro);
		
		return "ListaDesejo";
	}
	
	public String adicionarCarrinho(){
		CarrinhoMB cMB = new CarrinhoMB();
		System.out.println(livro.getId() + " - " + livro.getNomeLivro());
		cMB.setLivro(livro);
		cMB.adcionarCarrinho();
		removerListaDesejos();
		
		
		return "Carrinho";
	}
	
	public String removerListaDesejos(){
		Livro l = new Livro();
		for (int i = 0; i < listaDesejos.size(); i++) {
			l = listaDesejos.get(i);
			if(l.getId() == this.livro.getId()){
				listaDesejos.remove(i);
			}
		}
		
		return "ListaDesejos";
	}
	
}
