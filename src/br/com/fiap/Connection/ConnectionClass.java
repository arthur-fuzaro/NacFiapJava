package br.com.fiap.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	 public static Connection getConnection() throws SQLException{
	  
	  try {
	      Class.forName("com.mysql.jdbc.Driver");
	  } 
	  catch (ClassNotFoundException ex){ }
	  
	  String server = "gui.servermine.com.br";
	  String database = "FIAP";
	    
	  String url = "jdbc:mysql://" + server + "/" + database;
	  String user = "fiap";
	  String senha = "fiap";

	  Connection conn = DriverManager.getConnection(url, user, senha);

	  return conn;
	 }
}