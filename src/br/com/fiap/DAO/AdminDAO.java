package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Admin;
import br.com.fiap.Model.Autor;

public class AdminDAO {
	Connection conn;
	
	public AdminDAO(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
	}
	
	public Admin validarLogin(Admin admin){
		try {
			String sql = "SELECT * FROM Usuarios WHERE UserLogin = ? AND Senha = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getUser());
			pst.setString(2, admin.getPass());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Admin a = new Admin();
				a.setNome(rs.getString("Nome"));
				a.setUser(rs.getString("UserLogin"));
				a.setPass(rs.getString("Senha"));
				return a;
			}else{
				return null;
			}
			
		} catch (Exception e) {
			return null;
		}
	}
}
