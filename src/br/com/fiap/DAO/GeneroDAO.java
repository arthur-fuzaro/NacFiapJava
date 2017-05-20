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

	public GeneroDAO() {
		try {
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		} catch (SQLException ex) {
		}

	}

	public ArrayList<Genero> getTodosGeneros(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		ArrayList<Genero> Generos = new ArrayList<Genero>();
		int id;
		String nome;
		String sql = "SELECT * FROM Generos";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("GeneroId");
				nome = rs.getString("Nome");
				Genero genero = new Genero();
				genero.setId(id);
				genero.setNome(nome);
				Generos.add(genero);
			}
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro de execuÃƒÂ§ÃƒÂ£o: " + ex.getMessage() + " (Generos)");
		}
		return Generos;
	}

	public void inserirGenero(Genero g){
		String sql = "INSERT INTO Generos (Nome) VALUES(?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, g.getNome());
				
			if(stmt.executeUpdate()==1){
				System.out.println("Inserido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}

		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Genero)");
		}
	}

	public void removerGenero(int generoId)
	{
		String sql = "DELETE FROM Generos WHERE GeneroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, generoId);
			if(stmt.executeUpdate()==1)
				System.out.println("Genero removido com sucesso");
			else
				System.out.println("Ocorreu um erro ao remover o genero");
		}
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execução: " + ex.getMessage() + " (Genero) ");
		}
	}

	public void alterarGenero(Genero g, int generoId)
	{
		String sql = "UPDATE Generos SET Nome = ? WHERE GeneroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, g.getNome());
			stmt.setInt(2, generoId);
			if(stmt.executeUpdate()==1)
				System.out.println("Genero alterado com sucesso");
			else
				System.out.println("Ocorreu um erro ao alterar o genero");

		}	
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execuçãoo: " + ex.getMessage() + " (Genero)");
		}
	} 

	public Genero pesquisarGenero(int generoId)
	{
		Genero genero = null;
		String nome;
		String sql = "SELECT * FROM Generos WHERE generoId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, generoId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				nome = rs.getString("Nome");
				genero.setNome(nome);
			}
		}
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execução: " + ex.getMessage() + " (Generos) ");
		}

		return genero;

	}



}
