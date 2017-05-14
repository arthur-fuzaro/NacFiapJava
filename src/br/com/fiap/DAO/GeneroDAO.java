package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Genero;
import br.com.fiap.Model.Livro;

public class GeneroDAO {

Connection conn = null;

	public GeneroDAO(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		
	}
	
	public ArrayList<Genero> ListarGeneros(){
		ArrayList<Genero> Generos = new ArrayList<Genero>();
		int id;
		String nome;
		String sql = "SELECT * FROM Generos";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()){
			id= rs.getInt("GeneroId");
			nome = rs.getString("Nome");
			Generos.add(new Genero(id, nome));
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Generos)");
		}	
		return Generos;
	}
	
	
}
