package br.com.fiap.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ManegedBean.LivroMB;
import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Livro;

@SuppressWarnings("unused")
public class tests {

	public static void main(String[] args) {
		LivroDAO l = new LivroDAO();
		
							//Adicionar livro
		//Livro livro = new Livro(1, 2, 100, 1, "lalala2", 1, 1, 1);
		//l.inserirLivro(livro);
		
							//Listar todos os livros
		/*ArrayList<Livro> livroArray = l.listarLivros();
		for (Livro livro2 : livroArray) {
			System.out.println("Nome:"+livro2.getNomeLivro()+"\n");
		}*/
		
							//Remover Livro
		//l.removerLivro(6);
		
							//Alterar Livro
		//Livro livro = new Livro(1, 2, 100, 1, "Blevers2", 1, 1, 1);
		//l.alterarLivro(livro, 5);
		
		//Pesquisar livro (nome)
		/*ArrayList<Livro> livroArray = l.pesquisarLivro("lalasdfsd");
		System.out.println(livroArray.size());
		for (Livro livro2 : livroArray) {
			System.out.println("Nome:"+livro2.getNomeLivro()+"\n");
		}*/
		
		/*EditoraDAO e = new EditoraDAO();
		ArrayList<Editora> editoraArray = e.getTodasEditoras();
		for (Editora editora : editoraArray) {
			System.out.println("Nome:"+editora.getNome()+"\n");
		}*/
		
		/*LivroMB l1 = new LivroMB();
		List<Livro> a = l1.getLivros();
		for (Livro livro : a) {
			System.out.println(livro.getNomeLivro() + "\n");
		}*/
		
		AutorDAO a = new AutorDAO();
		System.out.println(a.pesquisarAutor(1));
		
		for (Autor livro : a.pesquisarAutor("Arthur")) {
			System.out.println("Nome: "+livro.getFirstName());
		}
		
	}

}
