package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Autor;

public class AutorDAO {

	private Connection conn = null;
	
	public AutorDAO() {
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		
	}
	
	public void inserirAutor(Autor l){
		String sql = "INSERT INTO Autores (First_name, Last_name) VALUES(?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, l.getFirstName());
			stmt.setString(2, l.getLastName());
					
			if(stmt.executeUpdate()==1){
				System.out.println("Inserido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}

		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Autor)");
		}
	}
	
	public void removerAutor(int autorId){
		String sql = "DELETE FROM Autores WHERE AutorId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, autorId);
			if(stmt.executeUpdate()==1){
				System.out.println("Removido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Autor)");
		}
	}
	
	public void AlterarAutor(){
		
	}
	
}
