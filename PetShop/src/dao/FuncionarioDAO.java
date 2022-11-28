package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Funcionario;
import persist.Conexao;
import util.Util;

public class FuncionarioDAO implements OperacoesDAO<Funcionario> {

	private static final Connection con = Conexao.getConexao();

	@Override
	public boolean inserir(Funcionario e) {

		String nome = e.getNome();
		String cpf = e.getCpf();
		String celular = e.getCelular();
		char genero = e.getGenero();
		LocalDate dataNascimento = e.getDataNascimento();
		Endereco endereco = e.getEndereco();
		String email = e.getEmail();
		double salario = e.getSalario();

		String sql = "INSERT INTO FUNCIONARIO (NOME, CPF, CELULAR, GENERO, DATANASCIMENTO, ENDERECO, EMAIL, SALARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, nome);
			pstmt.setString(2, cpf);
			pstmt.setString(3, celular);
			pstmt.setString(4, String.valueOf(genero)); // verificar o tipo do set char
			pstmt.setObject(5, dataNascimento);
			pstmt.setObject(6, endereco.toString()); // conferir se é o tipo correto para endereco
			pstmt.setString(7, email);
			pstmt.setDouble(8, salario);
			
			int res = pstmt.executeUpdate(); // retorna a quantidade de registros inseridos

			System.out.println("\nFuncionario "+nome+" inserido");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {

			System.out.println(ex);
		}
		return false;
	}

	@Override
	public boolean editar(Funcionario e) {

		int id = e.getId();
		String nome = e.getNome();
		String cpf = e.getCpf();
		String celular = e.getCelular();
		char genero = e.getGenero();
		LocalDate dataNascimento = e.getDataNascimento();
		String endereco = e.getEndereco().toString();
		String email = e.getEmail();
		double salario = e.getSalario();		

		String sql = "UPDATE FUNCIONARIO SET NOME = ?, CPF = ?, CELULAR = ?, GENERO = ?, DATANASCIMENTO = ?, ENDERECO = ?, EMAIL = ?, SALARIO = ? WHERE ID = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, nome);
			pstmt.setString(2, cpf);
			pstmt.setString(3, celular);
			pstmt.setString(4, String.valueOf(genero)); // verificar o tipo do set char
			pstmt.setObject(5, dataNascimento);
			pstmt.setObject(6, endereco); // conferir se é o tipo correto para endereco
			pstmt.setString(7, email);
			pstmt.setDouble(8, salario);
			pstmt.setInt(9, id);

			int res = pstmt.executeUpdate(); // retorna a quantidade de registros inseridos

			System.out.println("Funcionario: "+nome+" editado!");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return false;

	}

	@Override
	public boolean excluir(int id) {
		
		String sql = "DELETE FROM FUNCIONARIO WHERE ID = " + id;
		
		try (Statement stmt = con.createStatement();) {

			String nome = pesquisar(id).getNome();
			boolean res = stmt.execute(sql); // retorna a quantidade de registros inseridos
			System.out.println("Funcionario: "+nome+" excluido!");
			return res;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public Funcionario pesquisar(int id) {
		Funcionario p = new Funcionario();
		try {
			
			String sql = "SELECT * FROM FUNCIONARIO WHERE ID = "+id;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	        rs.next();
	        
	        String nome = rs.getString("nome");
	        String cpf = rs.getString("cpf");
	        char genero = rs.getString("genero").charAt(0);
	        String celular = rs.getString("celular");
	        String endereco = rs.getString("endereco");
	        String datanascimento = rs.getString("datanascimento");
	        String email = rs.getString("email");
	        double salario = rs.getDouble("salario");
	        
	        p = new Funcionario(nome, cpf, celular, genero, datanascimento, Util.DBdateFormatter, endereco, email, salario, id);
	        
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}
        
		System.out.println();
		return p;
	}

	@Override
	public List<Funcionario> listar() {
		List<Funcionario> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM FUNCIONARIO";
		
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String nome = rs.getString("nome");
		        String cpf = rs.getString("cpf");
		        char genero = rs.getString("genero").charAt(0);
		        String celular = rs.getString("celular");
		        String endereco = rs.getString("endereco");
		        String datanascimento = rs.getString("datanascimento");
		        String email = rs.getString("email");
		        double salario = rs.getDouble("salario");
		        int id = rs.getInt("id");
		        
		        Funcionario p = new Funcionario(nome, cpf, celular, genero, datanascimento, Util.DBdateFormatter, endereco, email, salario, id);
		        lista.add(p);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return lista;
	}

}
