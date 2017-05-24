package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Genero;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class PesquisarMB {
	
	private Autor autor;
	private Editora editora;
	private Genero genero;
	private Livro livro;
	
	
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
	
	public String pesquisar(){
		LivroMB l = new LivroMB();
		LivroDAO lDAO = new LivroDAO();
		String nomev = livro.getNomeLivro();
		String generov = genero.getNome();
		String autorv1 = autor.getFirstName(), autorv2 = autor.getLastName();
		String editorav = editora.getNome();
		l.setLivrosPesquisar(lDAO.pesquisarLivro(nomev, autorv1, autorv2, generov, editorav));
		return "Pesquisar";
	}
	
}
