package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Genero;

public class EditoraDAO {

	private Connection conn = null;
	
	public EditoraDAO() {
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		
	}
	
	public void inserirEditora(Editora e){
		String sql = "INSERT INTO Editoras (Nome, NomeFantasia, Cnpj, Endereco, Email) VALUES(?,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getNomeFantasia());
			stmt.setString(3, e.getCnpj());
			stmt.setString(4, e.getEndereco());
			stmt.setString(5, e.getEmail());
					
			if(stmt.executeUpdate()==1){
				System.out.println("Inserido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}

		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execu��o: "+ex.getMessage() + " (Editora)");
		}
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
				Editora editora = new Editora();
				editora.setId(id);
				editora.setCnpj(Cnpj);
				editora.setNome(Nome);
				editora.setNomeFantasia(NomeFantasia);
				editora.setEndereco(Endereco);
				editora.setEmail(Email);
				Editoras.add(editora);
			}
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro de execução: " + ex.getMessage() + " (Autores)");
		}
		return Editoras;
	}


	public void removerEditora(int editoraId)
	{
		String sql = "DELETE FROM Editoras WHERE EditoraId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, editoraId);
			if(stmt.executeUpdate()==1)
				System.out.println("Editora removido com sucesso");
			else
				System.out.println("Ocorreu um erro ao remover o editora");
		}
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execu��o: " + ex.getMessage() + " (editora) ");
		}
	}

	public void alterarEditora(Editora e, int editoraId)
	{
		String sql = "UPDATE Editoras SET Nome = ?, NomeFantasia = ?, Cnpj = ?, Endereco = ?, Email = ?  WHERE EditoraId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getNomeFantasia());
			stmt.setString(3, e.getCnpj());
			stmt.setString(4, e.getEndereco());
			stmt.setString(5, e.getEmail());
			stmt.setInt(6, editoraId);
			if(stmt.executeUpdate()==1)
				System.out.println("Editora alterado com sucesso");
			else
				System.out.println("Ocorreu um erro ao alterar o editora");

		}	
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execu��oo: " + ex.getMessage() + " (editora)");
		}
	} 

	public Editora pesquisarEditora(int editoraId)
	{
		Editora editora = new Editora();
		String nome, nomeFantasia, Cnpj, endereco, email;
		String sql = "SELECT * FROM Editoras WHERE EditoraId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, editoraId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				nome = rs.getString("Nome");
				nomeFantasia = rs.getString("nomeFantasia");
				Cnpj = rs.getString("Cnpj");
				endereco = rs.getString("Endereco");
				email = rs.getString("email");
				editora.setNome(nome);
				editora.setNomeFantasia(nomeFantasia);
				editora.setCnpj(Cnpj);
				editora.setEmail(email);
				editora.setEndereco(endereco);
				editora.setId(editoraId);
			}
		}
		catch(SQLException ex){
			System.out.println("Ocorreu um erro de execu��o: " + ex.getMessage() + " (Editoras) ");
		}

		return editora;

	}

}
