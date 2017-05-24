package br.com.fiap.ManegedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.DAO.AdminDAO;
import br.com.fiap.Model.Admin;

@ManagedBean
@SessionScoped
public class AdminMB {
	
	private static Admin admin;
	private String erro;
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public AdminMB(){
		admin = new Admin();
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login(){
		AdminDAO a = new AdminDAO();
		if(a.validarLogin(admin)) {
			return "admin"; 
		}else {
			setErro("Login ou senha invalidos");
			return "LoginADM";
		}
		
		
		
	}
	
}
