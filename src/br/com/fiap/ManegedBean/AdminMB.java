package br.com.fiap.ManegedBean;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.DAO.AdminDAO;
import br.com.fiap.Model.Admin;

@ManagedBean
@SessionScoped
public class AdminMB {
	
	private static Admin admin;
	private String erro;
	private String sucesso;
	private ResourceBundle resource;
	private FacesContext context;
	
	public String getSucesso() {
		String aux = this.sucesso;
		setSucesso("");
		return aux;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

	public String getErro() {
		String aux = this.erro;
		setErro("");
		return aux;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public AdminMB(){
		admin = new Admin();
		context = FacesContext.getCurrentInstance();
		resource = ResourceBundle.getBundle("language", context.getViewRoot().getLocale());
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login(){
		AdminDAO a = new AdminDAO();
		admin = a.validarLogin(admin);
		if(admin != null) {
			return "admin"; 
		}else {
			setErro(resource.getString("invalidLogin"));
			admin = new Admin();
			return "LoginADM";
		}
		
		
		
	}
	
	public String sairAdmin(){
		admin = new Admin();
		setSucesso(resource.getString("logout"));
		return "LoginADM";
	}
	
	public String getSair(){
		return "LoginADM";
	}
	
}
