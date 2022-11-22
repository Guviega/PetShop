package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Endereco;
import model.Funcionario;
import persist.Conexao;

public class FuncionarioDAO implements OperacoesDAO<Funcionario>{
	
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
		Double salario = e.getSalario();

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

			if (res == 1)
				return true;

		} catch (SQLException ex) {

			System.out.println(ex);
		}
		
		System.out.println("INSERIDO! " + e);
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(Funcionario e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario pesquisar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
