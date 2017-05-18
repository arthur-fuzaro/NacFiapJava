package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GeralMB {

	
	private static String sucesso;
	private static String erro;

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		GeralMB.erro = erro;
	}

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		GeralMB.sucesso = sucesso;
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
	
	public String abrirCadastroAutores(){
		return "Cadastro_Autor";
	}
	
	public String abrirCadastroUsuarios(){
		return "Cadastro_Usuario";
	}
	
	
}
