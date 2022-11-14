package dao;

import java.sql.*;
import java.time.LocalDate;
import model.Endereco;
import model.Pessoa;
import persist.Conexao;

public class PessoaDAO implements OperacoesDAO<Pessoa>{

	private static final Connection con = Conexao.getConexao();
	
	public boolean inserir(Pessoa e) {
		
		Pessoa p = e;
		int id = e.getId();
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
	    	pstmt.setString(4, String.valueOf(genero)); //verificar  o tipo do set char
	    	pstmt.setObject(5, dataNascimento); 
	    	pstmt.setObject(6, endereco); //conferir se é o tipo correto para endereco
	    	
	        int res = pstmt.executeUpdate(); //retorna a quantidade de registros inseridos
	            
	        if (res==1) return true;
	            
	    } catch (SQLException ex) {
	            
	    	System.out.println(ex);
	    }
	        return false;
	}
	
	public boolean editar(Pessoa e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pesquisar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
