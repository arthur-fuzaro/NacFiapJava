package br.com.fiap.ManegedBean;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import br.com.fiap.DAO.EditoraDAO;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Genero;

@ManagedBean
@SessionScoped
public class EditoraMB {

	private Editora editora;
	private EditoraDAO dao = new EditoraDAO();
	private List<Editora> listaEditora;
	private String erro, sucesso;
	private ResourceBundle resource;
	private FacesContext context;

	public List<Editora> getListaEditora() {
		listaEditora = dao.getTodasEditoras();
		return listaEditora;
	}

	public void setListaEditora(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
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

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public EditoraMB() {
		context = FacesContext.getCurrentInstance();
		resource = ResourceBundle.getBundle("language", context.getViewRoot().getLocale());
		editora = new Editora();
	}

	public String cadastrarEditora(){
		try{
			dao.inserirEditora(editora);
			setSucesso(resource.getString("registered"));
			setErro("");
			editora = new Editora();
			return "Cadastro_editora"; 
		}
		catch(Exception ex){
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_editora";
		}
	}

	public List<Editora> getItems() {
		EditoraDAO a = new EditoraDAO();
		return a.getTodasEditoras();
	}
	
	public String abrirCadastroEditar(){
		try{
			editora = dao.pesquisarEditora(editora.getId());
			
			return "Cadastro_editora";
		}
		catch(Exception e){
			String erro = e.getMessage();
			return "Cadastro_editora";
		}
	}
	
	public String excluirEditora(){
		try {
			dao.removerEditora(editora.getId());
			setSucesso(resource.getString("deleted"));
			setErro("");
			return "Cadastro_editora";
		} catch (Exception e) {
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_editora";
		}
		
	}
	
	public String editEditora(){
		try {
			dao.alterarEditora(editora, editora.getId());
			editora = new Editora();
			setSucesso(resource.getString("edited"));
			setErro("");
			return "Cadastro_editora";
		} catch (Exception e) {
			setErro(resource.getString("error2"));
			setSucesso("");
			return "Cadastro_editora";
		}
	}

}
