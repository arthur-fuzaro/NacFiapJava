package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.fiap.DAO.GeneroDAO;
import br.com.fiap.Model.Genero;

@ManagedBean
public class GeneroMB {
		
	private Genero generos;
	
	private List<Genero> list;
		
	public List<Genero> ListaGeneros(){
		GeneroDAO dao = new GeneroDAO();
		ArrayList<Genero> Generos = new ArrayList<Genero>();

		Generos = dao.ListarGeneros();
		return Generos;
	}
}
