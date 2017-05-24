package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Admin;

public class AdminDAO {
	Connection conn;
	
	public AdminDAO(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
	}
	
	public boolean validarLogin(Admin admin){
		try {
			String sql = "SELECT * FROM Usuarios WHERE UserLogin = ? AND Senha = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getUser());
			pst.setString(2, admin.getPass());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) return true; else return false;
			
		} catch (Exception e) {
			return false;
		}
	}
}
