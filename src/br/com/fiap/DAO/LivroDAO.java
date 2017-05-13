package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Livro;

public class LivroDAO {

	Connection conn = null;
	
	public LivroDAO(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("SUCESSO");
		}
		catch(SQLException ex){
			System.out.println(ex.toString());
			
		}
		
	}
	public void insert(){
		
		String sql = "INSERT INTO generos VALUES(?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 1);
			stmt.setString(2, "Teste");
			//stmt.setDouble(3, f.getSalario());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		
		
	}

}
