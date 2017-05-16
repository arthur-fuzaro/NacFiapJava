package br.com.fiap.ManegedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.DAO.EditoraDAO;
import br.com.fiap.Model.Editora;

@ManagedBean
public class EditoraMB {

	private Editora editora;
	private EditoraDAO dao = new EditoraDAO();
	private GeralMB mb = new GeralMB();

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

}
