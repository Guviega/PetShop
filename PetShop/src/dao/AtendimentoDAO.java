package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Atendimento;
import model.Endereco;
import model.Pessoa;
import model.Pet;
import persist.Conexao;
import util.Util;

public class AtendimentoDAO implements OperacoesDAO<Atendimento>{
	
	Connection con = Conexao.getConexao();

	@Override
	public boolean inserir(Atendimento e) {

		String descricao = e.getDescricao();
		double valor = e.getValor();
		LocalDate data = e.getData();
		int idPet = e.getPet().getId();
		int idFuncionario = e.getFuncionario().getId();

		String sql = "INSERT INTO ATENDIMENTO (DESCRICAO, VALOR, DATA, IDPET, IDFUNCIONARIO) VALUES (?,?,?,?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, descricao);
			pstmt.setDouble(2, valor);
			pstmt.setObject(3, data);
			pstmt.setInt(4, idPet);
			pstmt.setInt(5, idFuncionario);
			
			int res = pstmt.executeUpdate();
			
			System.out.println("\nAtendimento "+descricao+" inserido");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {

			System.out.println(ex);
		}
		return false;
	}

	@Override
	public boolean editar(Atendimento e) {

		int id = e.getId();
		String descricao = e.getDescricao();
		double valor = e.getValor();
		LocalDate data = e.getData();
		int idPet = e.getPet().getId();
		int idFuncionario = e.getFuncionario().getId();

		String sql = "UPDATE ATENDIMENTO SET DESCRICAO= ?, VALOR=?, DATA=?, IDPET=?, IDFUNCIONARIO=? WHERE ID = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, descricao);
			pstmt.setDouble(2, valor);
			pstmt.setObject(3, data);
			pstmt.setInt(4, idPet);
			pstmt.setInt(5, idFuncionario);
			pstmt.setInt(6, id);

			int res = pstmt.executeUpdate(); // retorna a quantidade de registros inseridos

			System.out.println("Atendimento: "+descricao+" editado!");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return false;

	}

	@Override
	public boolean excluir(int id) {
		
		String sql = "DELETE FROM ATENDIMENTO WHERE ID = " + id;
		
		try (Statement stmt = con.createStatement();) {

			String descricao = pesquisar(id).getDescricao();
			boolean res = stmt.execute(sql); // retorna a quantidade de registros inseridos
			System.out.println("Atendimento: "+descricao+" excluido!");
			return res;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public Atendimento pesquisar(int id) {
		Atendimento p = new Atendimento();
		try {
			
			String sql = "SELECT * FROM ATENDIMENTO WHERE ID = "+id;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	        rs.next();

	        String descricao = rs.getString("descricao");
	        double valor = rs.getDouble("valor");
	        String data = rs.getString("data");
	        int idpet = rs.getInt("idPet");
	        int idfuncionario = rs.getInt("idfuncionario");
	        
	        p = new Atendimento(descricao, valor, data, Util.DBdateFormatter, new PetDAO().pesquisar(idpet), new FuncionarioDAO().pesquisar(idfuncionario), id);
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}
        
		System.out.println();
		return p;
	}

	@Override
	public List<Atendimento> listar() {
		List<Atendimento> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM ATENDIMENTO";
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String descricao = rs.getString("descricao");
		        double valor = rs.getDouble("valor");
		        String data = rs.getString("data");
		        int idpet = rs.getInt("idPet");
		        int idfuncionario = rs.getInt("idfuncionario");
		        int id = rs.getInt("id");
		        
		        Atendimento a = new Atendimento(descricao, valor, data, Util.DBdateFormatter, new PetDAO().pesquisar(idpet), new FuncionarioDAO().pesquisar(idfuncionario), id);
		        lista.add(a);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return lista;
	}

}
