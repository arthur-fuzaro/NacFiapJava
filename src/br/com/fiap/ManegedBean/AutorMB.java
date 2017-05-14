package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import br.com.fiap.DAO.AutorDAO;
import br.com.fiap.Model.Autor;

@ManagedBean
public class AutorMB {
	
	private Autor autor = new Autor(0, null, null);
	private String erro;
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String cadastrarAutor(){
		try{
			AutorDAO dao = new AutorDAO();
			GeralMB mb = new GeralMB();
			dao.inserirAutor(autor);
			mb.setSucesso("Autor Cadastrado com Sucesso");
			return "Sucesso";
		}
		catch(Exception ex){
			erro = ex.getMessage();
			return "Erro";
		}
	}
	
	
	
	
	
	
}
