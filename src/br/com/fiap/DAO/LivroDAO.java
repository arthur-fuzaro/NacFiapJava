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
		String sql = "INSERT INTO Livros (CodIsbn, QtdPaginas, Edicao, AutoresId, GenerosId, EditorasId, Nome_livro, Preco)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, l.getCodIsbn());
			stmt.setInt(2, l.getPaginas());
			stmt.setInt(3, l.getEdicao());
			stmt.setInt(4, l.getAutorId());
			stmt.setInt(5, l.getGeneroId());
			stmt.setInt(6, l.getEditoraId());
			stmt.setString(7, l.getNomeLivro());
			stmt.setDouble(8, l.getPreco());
			
					
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
		Integer id, codIsbn, paginas, edicao, autorId, generoId, editoraId;
		Double preco;
		String nome;
		//(Integer id, Integer codIsbn, Integer paginas, Integer edicao, String nome, Integer autorId, Integer generoId, Integer editoraId)
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
				preco = rs.getDouble("Preco");
				//livros.add(new Livro(id, codIsbn, paginas, edicao, nome, autorId, generoId, editoraId));
				
				Livro livro = new Livro();
				livro.setId(id);
				livro.setCodIsbn(codIsbn);
				livro.setPaginas(paginas);
				livro.setAutorId(autorId);
				livro.setEdicao(edicao);
				livro.setNomeLivro(nome);
				livro.setGeneroId(generoId);
				livro.setEditoraId(editoraId);
				livro.setPreco(preco);
				livros.add(livro);
				
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livros;
	}
	
	public void removerLivro(Integer livroId){
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
	
	public void alterarLivro(Livro l, Integer livroId){
		String sql = "UPDATE Livros SET "
				+ "CodIsbn = ?, QtdPaginas = ?, Edicao = ?, AutoresId = ?, GenerosId = ?, EditorasId = ?, Nome_Livro = ?, Preco = ?"
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
			stmt.setDouble(8, l.getPreco());
			stmt.setInt(9, livroId);
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
	
	public Livro pesquisarLivro(Integer livroId){
		Livro livro = null;
		int id, codIsbn, paginas, edicao, autorId, generoId, editoraId;
		String nome;
		Double preco;
		
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
				preco = rs.getDouble("Preco");
				//livro = (new Livro(id, codIsbn, paginas, edicao, nome, autorId, generoId, editoraId));
				livro.setId(id);
				livro.setCodIsbn(codIsbn);
				livro.setPaginas(paginas);
				livro.setAutorId(autorId);
				livro.setEdicao(edicao);
				livro.setNomeLivro(nome);
				livro.setGeneroId(generoId);
				livro.setEditoraId(editoraId);
				livro.setPreco(preco);
				
				
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livro;
	}
	
	public ArrayList<Livro> pesquisarLivro(String livroNome){
		ArrayList<Livro> livros = new ArrayList<Livro>();
		Integer id, codIsbn, paginas, edicao, autorId, generoId, editoraId;
		String nome;
		Double preco;
		
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
				preco = rs.getDouble("Preco");
				//livros.add(new Livro(id, codIsbn, paginas, edicao, nome, autorId, generoId, editoraId));
				Livro livro = new Livro();
				livro.setId(id);
				livro.setCodIsbn(codIsbn);
				livro.setPaginas(paginas);
				livro.setAutorId(autorId);
				livro.setEdicao(edicao);
				livro.setNomeLivro(nome);
				livro.setGeneroId(generoId);
				livro.setEditoraId(editoraId);
				livro.setPreco(preco);
				livros.add(livro);
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livros;
	}

}
