package br.com.fiap.ManegedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.EditoraDAO;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Genero;

@ManagedBean
@SessionScoped
public class EditoraMB {

	private Editora editora;
	private EditoraDAO dao = new EditoraDAO();
	private GeralMB mb = new GeralMB();
	private List<Editora> listaEditora;
	private String erro, sucesso;

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
		editora = new Editora();
	}

	public String cadastrarEditora(){
		try{
			dao.inserirEditora(editora);
			mb.setSucesso("Editora cadastrado com sucesso");
			return "Sucesso"; 
		}
		catch(Exception ex){
			mb.setErro(ex.getMessage());
			return "Erro";
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
			mb.setErro(erro);
			return "Erro";
		}
	}
	
	public String excluirEditora(){
		try {
			dao.removerEditora(editora.getId());
			setSucesso("Livro deletado com sucesso");
			setErro("");
			return "Cadastrar_editora";
		} catch (Exception e) {
			mb.setErro("Ocorreu um erro ao tentar deletar a editora!");
			setErro("Ocorreu um erro ao tentar deletar a editora!");
			return "erro";
		}
		
	}
	
	public String editEditora(){
		try {
			dao.alterarEditora(editora, editora.getId());
			editora = new Editora();
			setSucesso("Genero alterado com sucesso");
			setErro("");
			return "Cadastro_editora";
		} catch (Exception e) {
			mb.setErro(e.getMessage());
			return "Erro";
		}
	}

}
