package br.com.fiap.ManegedBean;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.DAO.AutorDAO;
import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;

@ManagedBean
public class AutorMB {
	
	private AutorDAO dao = new AutorDAO();
	private Autor autor;
	private List<Autor> items;
	private List<Autor> listaAutor;
	private String erro, sucesso;
	private ResourceBundle resource;
	private FacesContext context;
	
	public List<Autor> getListaAutor() {
		listaAutor = dao.getTodosAutores();
		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

	public AutorMB(){
		context = FacesContext.getCurrentInstance();
		resource = ResourceBundle.getBundle("language", context.getViewRoot().getLocale());
		autor = new Autor();
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getItems(){
       AutorDAO a = new AutorDAO();
       return a.getTodosAutores();
   }

	public String cadastrarAutor(){
		try{
			dao.inserirAutor(autor);
			setSucesso(resource.getString("registered"));
			setErro("");
			autor = new Autor();
			return "Cadastro_Autor";
		}
		catch(Exception ex){
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_Autor";
		}
	}
	
	public String abrirCadastroEditar(){
		try{
			autor = dao.pesquisarAutor(autor.getId());
		
			return "Cadastro_Autor";
		}
		catch(Exception e){
			String erro = e.getMessage();
			return "Cadastro_Autor";
		}
	}
	
	public String excluirAutor(){
		try {
			dao.removerAutor(autor.getId());
			setSucesso(resource.getString("deleted"));
			setErro("");
			return "Cadastro_Autor";
		} catch (Exception e) {
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_Atuor";
		}
		
	}
	
	public String editAutor(){
		System.out.println("ENTROU AQUI POAR");
		try {
			dao.alterarAutor(autor, autor.getId());
			autor = new Autor();
			setSucesso(resource.getString("edited"));
			setErro("");
			return "Cadastro_Autor";
		} catch (Exception e) {
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_Autor";
		}
	}
	
	
	
	
}
