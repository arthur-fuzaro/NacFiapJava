package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.Connection.ConnectionClass;
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
	
	public void inserirEditora(Editora e){
		String sql = "INSERT INTO Editoras (Nome, NomeFantasia, Cnpj, Endereco, Email) VALUES(?,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getNomeFantasia());
			stmt.setString(3, e.getEndereco());
			stmt.setString(4, e.getEmail());
					
			if(stmt.executeUpdate()==1){
				System.out.println("Inserido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}

		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Editora)");
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
			System.out.println("Ocorreu um erro de execuÃ§Ã£o: " + ex.getMessage() + " (Autores)");
		}
		return Editoras;
	}


}
