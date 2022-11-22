package dao;

import java.sql.*;
import java.time.LocalDate;
import model.Endereco;
import model.Pessoa;
import persist.Conexao;

public class ClienteDAO implements OperacoesDAO<Pessoa> {

	private static final Connection con = Conexao.getConexao();

	@Override
	public boolean inserir(Pessoa e) {

		String nome = e.getNome();
		String cpf = e.getCpf();
		String celular = e.getCelular();
		char genero = e.getGenero();
		LocalDate dataNascimento = e.getDataNascimento();
		Endereco endereco = e.getEndereco();

		String sql = "INSERT INTO CLIENTE (NOME, CPF, CELULAR, GENERO, DATANASCIMENTO, ENDERECO) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, nome);
			pstmt.setString(2, cpf);
			pstmt.setString(3, celular);
			pstmt.setString(4, String.valueOf(genero)); // verificar o tipo do set char
			pstmt.setObject(5, dataNascimento);
			pstmt.setObject(6, endereco.toString()); // conferir se é o tipo correto para endereco

			int res = pstmt.executeUpdate(); // retorna a quantidade de registros inseridos

			System.out.println("\nCliente "+nome+" inserido");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {

			System.out.println(ex);
		}
		
		System.out.println("INSERIDO! " + e);
		return false;
	}

	@Override
	public boolean editar(Pessoa e) {

		int id = e.getId();
		String nome = e.getNome();
		String cpf = e.getCpf();
		String celular = e.getCelular();
		char genero = e.getGenero();
		LocalDate dataNascimento = e.getDataNascimento();
		String endereco = e.getEndereco().toString();

		String sql = "UPDATE CLIENTE SET NOME = ?, CPF = ?, CELULAR = ?, GENERO = ?, DATANASCIMENTO = ?, ENDERECO = ? WHERE ID = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, nome);
			pstmt.setString(2, cpf);
			pstmt.setString(3, celular);
			pstmt.setString(4, String.valueOf(genero)); // verificar o tipo do set char
			pstmt.setObject(5, dataNascimento);
			pstmt.setObject(6, endereco); // conferir se é o tipo correto para endereco
			pstmt.setInt(7, id);

			int res = pstmt.executeUpdate(); // retorna a quantidade de registros inseridos

			if (res == 1)
				return true;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		System.out.println("EDITADO! " + e);
		return false;

	}

	@Override
	public boolean excluir(int id) {
		
		String sql = "DELETE FROM CLIENTE WHERE ID = " + id;
		
		try (Statement stmt = con.createStatement();) {

			boolean res = stmt.execute(sql); // retorna a quantidade de registros inseridos
			//System.out.println("Cliente "+  + " excluido");
			return res;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public Pessoa pesquisar(int id) {
		Pessoa p = null;
		try {
			
			String sql = "SELECT * FROM CLIENTE WHERE ID = "+id;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	        rs.next();
	        
	        String nome = rs.getString("nome");
	        String cpf = rs.getString("cpf");
	        char genero = rs.getString("genero").charAt(0);
	        String celular = rs.getString("celular");
	        String endereco = rs.getString("endereco");
	        String datanascimento = rs.getString("datanascimento");
	        
	        p = new Pessoa(nome, cpf, celular, genero, datanascimento, endereco);
	        
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}
        
		System.out.println();
		return p;
	}

}
