package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;

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
			System.out.println("Ocorreu um erro de execu��o: "+ex.getMessage() + " (Autor)");
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
			System.out.println("Ocorreu um erro de execu��o: "+ex.getMessage() + " (Autor)");
		}
	}
	
	public void AlterarAutor(){
		
	}
	public ArrayList<Autor> getTodosAutores(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		ArrayList<Autor> Autores = new ArrayList<Autor>();
		int id;
		String nome,sobrenome;
		String sql = "SELECT * FROM Autores";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("AutorId");
				nome = rs.getString("First_Name");
				sobrenome = rs.getString("Last_name");
				//Autores.add(new Autor(id, nome, sobrenome));
				
				Autor autor = new Autor();
				autor.setFirstName(nome);
				autor.setLastName(sobrenome);
				autor.setId(id);
				Autores.add(autor);
			}
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro de execução: " + ex.getMessage() + " (Autores)");
		}
		return Autores;
	}

	
	public void alterarAutor(Autor a, int autorId)
	{
		String sql = "UPDATE Autores SET First_name = ?, Last_name = ?  WHERE AutorId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getFirstName());
			stmt.setString(2, a.getLastName());
			stmt.setInt(3, autorId);
			if(stmt.executeUpdate()==1)
				System.out.println("Autor alterado com sucesso");
			else
				System.out.println("Ocorreu um erro ao alterar o Autor");

		}	
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execucao: " + ex.getMessage() + " (Autor)");
		}
	} 

	public Autor pesquisarAutor(int autorId)
	{
		Autor autor = new Autor();
		String first_name, last_name;
		String sql = "SELECT * FROM Autores WHERE AutorId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, autorId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				first_name = rs.getString("First_name");
				last_name = rs.getString("Last_name");
				autor.setFirstName(first_name);
				autor.setLastName(last_name);
				autor.setId(autorId);
			}
		}
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execucao: " + ex.getMessage() + " (Autor) ");
		}

		return autor;

	}

	
	
}
