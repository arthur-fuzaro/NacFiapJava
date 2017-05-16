package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.DAO.GeneroDAO;
import br.com.fiap.Model.Genero;

@ManagedBean
@RequestScoped
public class GeneroMB {
		
		private Genero genero;
		private GeneroDAO dao;
		private GeralMB mb;
	
		public GeneroMB(){
			genero = new Genero();
			dao = new GeneroDAO();
			mb = new GeralMB();
		}
	
		public List<Genero> getItems(){
			GeneroDAO g = new GeneroDAO();
	       	 
			return g.getTodosGeneros();
		}
	   
		public List<String> getItemName(){
			GeneroDAO g = new GeneroDAO();
			ArrayList<Genero> ge = g.getTodosGeneros();
	       	List<String> nomes = new ArrayList<String>();
	       	for (Genero ge2 : ge) {
				nomes.add(ge2.getNome());
			}
	       	return nomes;
		}
	   
		
		
}
