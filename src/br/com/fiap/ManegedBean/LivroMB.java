package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Livro;

@ManagedBean
public class LivroMB {
	
	private Livro livro = new Livro(0, 0, 0, 0, null, 0, 0, 0);
	private int id;
	
	public Livro getLivro() {
		return livro;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String abrirCadastroLivros(){
		return "Cadastro_livro";
	}
	
	public String abrirCadastroGeneros(){
		return "Cadastro_Genero";
	}
	
	public String abrirCadastroEditoras(){
		return "Cadastro_editora";
	}
	
	public String abrirCadastroAtuores(){
		return "Cadastro_Autor";
	}
	
	public String abrirCadastroUsuarios(){
		return "Cadastro_Usuario";
	}

	public void cadastrarLivro(){
		LivroDAO dao = new LivroDAO();
		System.out.println(getId() + " - " + livro.getNomeLivro() + " - " + livro.getGeneroId());
		livro = new Livro(livro.getId(), livro.getCodIsbn(), livro.getPaginas(), livro.getEdicao(), livro.getNomeLivro(), livro.getAutorId(), livro.getGeneroId(), livro.getEditoraId());
		
		dao.inserirLivro(livro);
	}
	
}
