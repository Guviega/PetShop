package persist;

import java.sql.*;

public class Conexao {
	
	 public static Connection getConexao() {
		 
		 Connection conexao = null;
		 try {
			 
			 Class.forName("org.postgresql.Driver");
			 String username = ""; //colocar user aqui
			 String password = ""; //colocar senha aqui
			 String url = "jdbc:postgresql://localhost:5432/petshop"; //verificar nome do bd
			 conexao = DriverManager.getConnection(url, username, password);
			 
		 } catch (ClassNotFoundException e) {
			 
			 System.out.println("Driver não encontrado!" + e);
			 
		 } catch (SQLException e) {
			 
			 e.printStackTrace();
		 }

		 System.out.println("-------------- CONEXÃO CRIADA ! -------------------");
       
		 return conexao;
		 
	 }
}
