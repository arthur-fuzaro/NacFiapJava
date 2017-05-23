package br.com.fiap.ManegedBean;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Genero;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class PesquisarMB {
	Autor autor;
	Editora editora;
	Genero genero;
	Livro livro;
	
	
	public PesquisarMB(){
		autor = new Autor();
		editora = new Editora();
		genero = new Genero();
		livro = new Livro();
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public Editora getEditora() {
		return editora;
	}


	public void setEditora(Editora editora) {
		this.editora = editora;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	
}
