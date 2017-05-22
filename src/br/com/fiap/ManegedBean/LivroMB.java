package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class LivroMB {
	
	private Livro livro;
	private List<Livro> livros;
	private String erro, sucesso;
	private ResourceBundle resource;
	private FacesContext context;
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroMB(){
		livro = new Livro();
		context = FacesContext.getCurrentInstance();
		resource = ResourceBundle.getBundle("language", context.getViewRoot().getLocale());
		setErro("");
		setSucesso("");
		//ListarLivros = new ArrayList<Livro>();

	}
	
	public String cadastrarLivro(){
		try{
			LivroDAO dao = new LivroDAO();
			dao.inserirLivro(livro);
			setSucesso(resource.getString("registered"));
			setErro("");
			//livro = new Livro();
			return "Cadastro_livro";
		}
		catch(Exception ex){
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_livro";
		}
	}
	public List<Livro> getLivros(){
		LivroDAO l = new LivroDAO();
		livros = l.listarLivros();
		return livros;
	}

	public void setLivros(ArrayList<Livro> listarLivros) {
		this.livros = listarLivros;
	}
	
	public String abrirCadastroEditar(){

		
		try{
			LivroDAO dao = new LivroDAO();
			livro = dao.pesquisarLivro(livro.getId());
			
			return "Cadastro_livro";
		}
		catch(Exception e){
			String erro = e.getMessage();
			return "Cadastro_livro";
		}
	}
	
	public String editarLivro(){
		try {
			LivroDAO l = new LivroDAO();
			l.alterarLivro(livro, livro.getId());
			setSucesso(resource.getString("edited"));
			setErro("");
			livro = new Livro();
			return "Cadastro_livro";
		} catch (Exception e) {
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_livro";
		}
	}
	
	public String excluirLivro(){
		try {
			LivroDAO dao = new LivroDAO();
			dao.removerLivro(livro.getId());
			setSucesso(resource.getString("deleted"));
			setErro("");
			return "Cadastro_livro";
		} catch (Exception e) {
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_livro";
		}
		
	}

	public String getErro() {
		String erro = this.erro;
		setErro("");
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getSucesso() {
		String sucesso = this.sucesso;
		setSucesso("");
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}
	
	public String onload(){
	    return "index";
	}
	
	
}
