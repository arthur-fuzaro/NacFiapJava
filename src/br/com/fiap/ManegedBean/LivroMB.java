package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;

import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Livro;

@ManagedBean
public class LivroMB {
	
	private Livro livro;
	private GeralMB mb = new GeralMB();
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroMB(){
		livro = new Livro();
	}
	
	public String cadastrarLivro(){
		try{
		LivroDAO dao = new LivroDAO();
		dao.inserirLivro(livro);
		mb.setSucesso("Livro cadastrado com sucesso");
		return "Erro";
		}
		catch(Exception ex){
			mb.setErro(ex.getMessage());
			return "Erro";
		}
	}
	
}
