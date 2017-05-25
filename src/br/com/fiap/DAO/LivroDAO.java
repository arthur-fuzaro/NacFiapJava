package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.Connection.ConnectionClass;
import br.com.fiap.Model.Autor;
import br.com.fiap.Model.Editora;
import br.com.fiap.Model.Genero;
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
		String sql = "INSERT INTO Livros (CodIsbn, QtdPaginas, Edicao, Autor, Genero, Editora, Nome_livro, Preco, Desconto)"
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, l.getCodIsbn());
			stmt.setInt(2, l.getPaginas());
			stmt.setInt(3, l.getEdicao());
			stmt.setString(4, l.getAutor());
			stmt.setString(5, l.getGenero());
			stmt.setString(6, l.getEditora());
			stmt.setString(7, l.getNomeLivro());
			stmt.setDouble(8, l.getPreco());
			stmt.setDouble(9, l.getDesconto());
			if(stmt.executeUpdate()==1){
				System.out.println("Inserido com sucesso");
			}else{
				System.out.println("Ocorreu um erro");
			}
			l = new Livro();

		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
	}
	
	public ArrayList<Livro> listarLivros(){
		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		//(Integer id, Integer codIsbn, Integer paginas, Integer edicao, String nome, Integer autorId, Integer generoId, Integer Editora)
		String sql = "SELECT * FROM Livros";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()){
				Livro livro = new Livro();
				livro.setId(rs.getInt("LivroId"));
				livro.setCodIsbn(rs.getInt("CodIsbn"));
				livro.setPaginas(rs.getInt("QtdPaginas"));
				livro.setAutor(rs.getString("Autor"));
				livro.setEdicao(rs.getInt("Edicao"));
				livro.setNomeLivro(rs.getString("Nome_Livro"));
				livro.setGenero(rs.getString("Genero"));
				livro.setEditora(rs.getString("Editora"));
				livro.setDesconto(rs.getDouble("Desconto"));
				livro.setPreco(rs.getDouble("Preco"));
				livros.add(livro);
				
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livros;
	}
	
	public ArrayList<Livro> listarLivrosDesconto(){
		Livro livro = new Livro();
		ArrayList<Livro> livros = new ArrayList<Livro>();
		//(Integer id, Integer codIsbn, Integer paginas, Integer edicao, String nome, Integer autorId, Integer generoId, Integer Editora)
		String sql = "SELECT * FROM Livros WHERE desconto != 0";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()){
				livro.setId(rs.getInt("LivroId"));
				livro.setCodIsbn(rs.getInt("CodIsbn"));
				livro.setPaginas(rs.getInt("QtdPaginas"));
				livro.setAutor(rs.getString("Autor"));
				livro.setEdicao(rs.getInt("Edicao"));
				livro.setNomeLivro(rs.getString("Nome_Livro"));
				livro.setGenero(rs.getString("Genero"));
				livro.setEditora(rs.getString("Editora"));
				livro.setDesconto(rs.getDouble("Desconto"));
				livro.setPreco(rs.getDouble("Preco"));
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
	
	public void alterarLivro(Livro l, int livroId){
		String sql = "UPDATE Livros SET "
				+ "CodIsbn = ?, QtdPaginas = ?, Edicao = ?, Autor = ?, Genero = ?, Editora = ?, Nome_Livro = ?, Preco = ?, Desconto = ?"
				+ "WHERE LivroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, l.getCodIsbn());
			stmt.setInt(2, l.getPaginas());
			stmt.setInt(3, l.getEdicao());
			stmt.setString(4, l.getAutor());
			stmt.setString(5, l.getGenero());
			stmt.setString(6, l.getEditora());
			stmt.setString(7, l.getNomeLivro());
			stmt.setDouble(8, l.getPreco());
			stmt.setDouble(9, l.getDesconto());
			stmt.setInt(10, livroId);
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
		Livro livro = new Livro();
		
		String sql = "SELECT * FROM Livros WHERE LivroId = ?";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, livroId);
			ResultSet rs = stmt.executeQuery();			
			if(rs.next()){
				livro.setId(rs.getInt("LivroId"));
				livro.setCodIsbn(rs.getInt("CodIsbn"));
				livro.setPaginas(rs.getInt("QtdPaginas"));
				livro.setAutor(rs.getString("Autor"));
				livro.setEdicao(rs.getInt("Edicao"));
				livro.setNomeLivro(rs.getString("Nome_Livro"));
				livro.setGenero(rs.getString("Genero"));
				livro.setEditora(rs.getString("Editora"));
				livro.setDesconto(rs.getDouble("Desconto"));
				livro.setPreco(rs.getDouble("Preco"));
				
			}
		}
		catch(SQLException ex){ 
			System.out.println("Ocorreu um erro de execução: "+ex.getMessage() + " (Livros)");
		}
		return livro;
	}
	
public List<Livro> pesquisarLivro(String search){
		
		List<Livro> livros = new ArrayList<Livro>();
		
		String sql = "SELECT * FROM Livros WHERE UPPER(Nome_Livro) like UPPER(?) OR UPPER(Autor) like UPPER(?) OR UPPER(Genero) like UPPER(?) OR UPPER(Editora) like UPPER(?)";
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+search+"%");
			stmt.setString(2, "%"+search+"%");
			stmt.setString(3, "%"+search+"%");
			stmt.setString(4, "%"+search+"%");
			System.out.println(""+stmt);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()){
				Livro livro = new Livro();
				livro.setId(rs.getInt("LivroId"));
				livro.setCodIsbn(rs.getInt("CodIsbn"));
				livro.setPaginas(rs.getInt("QtdPaginas"));
				livro.setAutor(rs.getString("Autor"));
				livro.setEdicao(rs.getInt("Edicao"));
				livro.setNomeLivro(rs.getString("Nome_Livro"));
				livro.setGenero(rs.getString("Genero"));
				livro.setEditora(rs.getString("Editora"));
				livro.setDesconto(rs.getDouble("Desconto"));
				livro.setPreco(rs.getDouble("Preco"));
				livros.add(livro);
			}
		}
		catch(Exception ex){ 
			System.out.println("Ocorreu um erro de execução Pesquisar Livro: "+ex.getMessage() + " (Livros)");
		}
		return livros;
	}
public List<Livro> pesquisarLivro(String nome, String autor, String autor2, String genero, String editora){
	
	List<Livro> livros = new ArrayList<Livro>();
	
	String sql = "SELECT * FROM Livros WHERE UPPER(Nome_Livro) like UPPER(?) and (UPPER(Autor)  like UPPER(?) OR UPPER(Autor)  like UPPER(?))  and UPPER(Genero) like UPPER(?) and UPPER(Editora) like UPPER(?)";
	try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%"+nome+"%");
		stmt.setString(2, "%"+autor+"%");
		stmt.setString(3, "%"+autor2+"%");
		stmt.setString(4, "%"+genero+"%");
		stmt.setString(5, "%"+editora+"%");
		ResultSet rs = stmt.executeQuery();			
		while(rs.next()){
			Livro livro = new Livro();
			livro.setId(rs.getInt("LivroId"));
			livro.setCodIsbn(rs.getInt("CodIsbn"));
			livro.setPaginas(rs.getInt("QtdPaginas"));
			livro.setAutor(rs.getString("Autor"));
			livro.setEdicao(rs.getInt("Edicao"));
			livro.setNomeLivro(rs.getString("Nome_Livro"));
			livro.setGenero(rs.getString("Genero"));
			livro.setEditora(rs.getString("Editora"));
			livro.setDesconto(rs.getDouble("Desconto"));
			livro.setPreco(rs.getDouble("Preco"));
			livros.add(livro);
		}
	}
	catch(Exception ex){ 
		System.out.println("Ocorreu um erro de execução Pesquisar Livro: "+ex.getMessage() + " (Livros)");
	}
	return livros;
}


}
