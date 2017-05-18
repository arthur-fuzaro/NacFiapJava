package br.com.fiap.ManegedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import br.com.fiap.DAO.AutorDAO;
import br.com.fiap.Model.Autor;

@ManagedBean
public class AutorMB {
	
	private GeralMB mb = new GeralMB();
	
	private Autor autor;
	
	public AutorMB(){
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
			AutorDAO dao = new AutorDAO();
			dao.inserirAutor(autor);
			mb.setSucesso("Autor Cadastrado com Sucesso");
			return "Sucesso";
		}
		catch(Exception ex){
			mb.setErro(ex.getMessage());
			return "Erro";
		}
	}
	
	
	
	
	
	
}
