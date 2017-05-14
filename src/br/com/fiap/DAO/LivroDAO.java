package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Livro;

public class LivroDAO {

	Connection conn = null;
	
	public LivroDAO(){
		try{
			conn = ConnectionClass.getConnection();
			System.out.println("sucesso");
		}
		catch(SQLException ex){}
		
	}
	public void inserirLivro(Livro l){
		String sql = "INSERT INTO Livros (CodIsbn, QtdPaginas, Edicao, AutoresId, GenerosId, EditorasId, Nome_livro)"
				+ " VALUES(?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, l.getCodIsbn());
			stmt.setInt(2, l.getPaginas());
			stmt.setInt(3, l.getEdicao());
			stmt.setInt(4, l.getAutorId());
			stmt.setInt(5, l.getGeneroId());
			stmt.setInt(6, l.getEditoraId());
			stmt.setString(7, l.getNomeLivro());
			
					
			if(stmt.executeUpdate()==1){
				System.out.println("Inserido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}

		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
	}
	
	public ArrayList<Livro> listarLivros(){
		ArrayList<Livro> livros = new ArrayList<Livro>();
		int id, codIsbn, paginas, edicao, autorId, generoId, editoraId;
		String nome;
		//(int id, int codIsbn, int paginas, int edicao, String nome, int autorId, int generoId, int editoraId)
		String sql = "SELECT * FROM Livros";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()){
				id = rs.getInt("LivroId");
				codIsbn = rs.getInt("CodIsbn");
				paginas = rs.getInt("QtdPaginas");
				edicao = rs.getInt("Edicao");
				autorId = rs.getInt("AutoresId");
				generoId = rs.getInt("GenerosId");
				editoraId = rs.getInt("EditorasId");
				nome = rs.getString("Nome_Livro");
				livros.add(new Livro(id, codIsbn, paginas, edicao, nome, autorId, generoId, editoraId));
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livros;
	}
	
	public void removerLivro(int livroId){
		String sql = "DELETE FROM Livros WHERE LivroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, livroId);
			if(stmt.executeUpdate()==1){
				System.out.println("Removido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		
		
	}
	
	public void alterarLivro(Livro l, int livroId){
		String sql = "UPDATE Livros SET "
				+ "CodIsbn = ?, QtdPaginas = ?, Edicao = ?, AutoresId = ?, GenerosId = ?, EditorasId = ?, Nome_Livro = ?"
				+ "WHERE LivroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, l.getCodIsbn());
			stmt.setInt(2, l.getPaginas());
			stmt.setInt(3, l.getEdicao());
			stmt.setInt(4, l.getAutorId());
			stmt.setInt(5, l.getGeneroId());
			stmt.setInt(6, l.getEditoraId());
			stmt.setString(7, l.getNomeLivro());
			stmt.setInt(8, livroId);
			if(stmt.executeUpdate()==1){
				System.out.println("Alterado com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		
	}
	
	public Livro pesquisarLivro(int livroId){
		Livro livro = null;
		int id, codIsbn, paginas, edicao, autorId, generoId, editoraId;
		String nome;
		
		String sql = "SELECT * FROM Livros WHERE LivroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, livroId);
			ResultSet rs = stmt.executeQuery();			
			if(rs.next()){
				id = rs.getInt("LivroId");
				codIsbn = rs.getInt("CodIsbn");
				paginas = rs.getInt("QtdPaginas");
				edicao = rs.getInt("Edicao");
				autorId = rs.getInt("AutoresId");
				generoId = rs.getInt("GenerosId");
				editoraId = rs.getInt("EditorasId");
				nome = rs.getString("Nome_Livro");
				livro = (new Livro(id, codIsbn, paginas, edicao, nome, autorId, generoId, editoraId));
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livro;
	}
	
	public ArrayList<Livro> pesquisarLivro(String livroNome){
		ArrayList<Livro> livros = new ArrayList<Livro>();
		int id, codIsbn, paginas, edicao, autorId, generoId, editoraId;
		String nome;
		
		String sql = "SELECT * FROM Livros WHERE Nome_Livro  LIKE ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+livroNome+"%");
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()){
				id = rs.getInt("LivroId");
				codIsbn = rs.getInt("CodIsbn");
				paginas = rs.getInt("QtdPaginas");
				edicao = rs.getInt("Edicao");
				autorId = rs.getInt("AutoresId");
				generoId = rs.getInt("GenerosId");
				editoraId = rs.getInt("EditorasId");
				nome = rs.getString("Nome_Livro");
				livros.add(new Livro(id, codIsbn, paginas, edicao, nome, autorId, generoId, editoraId));
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livros;
	}

}
