package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;

public class EditoraDAO {

	private Connection conn = null;
	
	public EditoraDAO() {
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		
	}
	
	public ArrayList<Editora> getTodasEditoras(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		ArrayList<Editora> Editoras = new ArrayList<Editora>();
		int id;
		String Nome, NomeFantasia, Cnpj, Endereco, Email;
		String sql = "SELECT * FROM Editoras";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("EditoraId");
				Nome = rs.getString("Nome");
				NomeFantasia = rs.getString("NomeFantasia");
				Cnpj = rs.getString("Cnpj");
				Endereco = rs.getString("Endereco");
				Email = rs.getString("Email");
				Editoras.add(new Editora(id, Nome, NomeFantasia, Cnpj, Endereco, Email));
			}
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro de execução: " + ex.getMessage() + " (Autores)");
		}
		return Editoras;
	}


}
