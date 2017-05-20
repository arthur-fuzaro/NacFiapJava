package br.com.fiap.ManegedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.GeneroDAO;
import br.com.fiap.DAO.LivroDAO;
import br.com.fiap.Model.Genero;
import br.com.fiap.Model.Livro;

@ManagedBean
@SessionScoped
public class GeneroMB {
		
		private Genero gen;
		private GeneroDAO dao;
		private GeralMB mb;
		private List<Genero> listGeneros;
		private String erro, sucesso;
	
		public String getErro() {
			String erro = this.erro;
			setErro("");
			return erro;
		}

		public void setErro(String erro) {
			this.erro = erro;
		}

		public String getSucesso() {
			String sucesso = this.sucesso;
			setSucesso("");
			return sucesso;
		}

		public void setSucesso(String sucesso) {
			this.sucesso = sucesso;
		}

		public GeneroMB(){
			gen = new Genero();
			dao = new GeneroDAO();
			mb = new GeralMB();
		}
			
		public List<Genero> getListGeneros() {
			listGeneros = dao.getTodosGeneros();
			return listGeneros;
		}

		public void setListGeneros(List<Genero> listGeneros) {
			this.listGeneros = listGeneros;
		}

		public Genero getGen() {
			return gen;
		}

		public void setGen(Genero gen) {
			this.gen = gen;
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
		public String cadastrarGenero(){
			try{
				dao.inserirGenero(gen);
				setSucesso("Livro Cadastrado com sucesso");
				setErro("");
				return "Cadastro_Genero";
			}
			catch(Exception ex){
				mb.setErro(ex.getMessage());
				return "Erro";
			}
		}

		public String abrirCadastroEditar(){
			try{
				gen = dao.pesquisarGenero(gen.getId());
				
				return "Cadastro_Genero";
			}
			catch(Exception e){
				String erro = e.getMessage();
				mb.setErro(erro);
				return "Erro";
			}
		}
		
		public String excluirGenero(){
			try {
				dao.removerGenero(gen.getId());
				setSucesso("Livro deletado com sucesso");
				setErro("");
				return "Cadastrar_Genero";
			} catch (Exception e) {
				mb.setErro("Ocorreu um erro ao tentar deletar o livro!");
				setErro("Ocorreu um erro ao tentar deletar o livro!");
				return "erro";
			}
			
		}
		
		public String editGenero(){
			try {
				dao.alterarGenero(gen, gen.getId());
				gen = new Genero();
				setSucesso("Genero alterado com sucesso");
				setErro("");
				return "Cadastro_Genero";
			} catch (Exception e) {
				mb.setErro(e.getMessage());
				return "Erro";
			}
		}



}
