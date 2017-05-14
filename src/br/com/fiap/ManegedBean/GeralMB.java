package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GeralMB {

	
	private static String sucesso;

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}
	
	
	
}
