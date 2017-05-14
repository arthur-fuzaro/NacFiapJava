package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.DAO.EditoraDAO;
import br.com.fiap.Model.Editora;

@ManagedBean
public class EditoraMB {
	
	private List<Editora> itemsList;
	public EditoraMB(){
      itemsList = new ArrayList<Editora>();
	}

   public List<Editora> getItems(){
       EditoraDAO a = new EditoraDAO();
       return a.getTodasEditoras();
   }
   
}
