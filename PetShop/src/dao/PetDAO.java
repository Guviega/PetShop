package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Pessoa;
import model.Pet;
import persist.Conexao;
import util.Util;

public class PetDAO implements OperacoesDAO<Pet>{
	
	Connection con = Conexao.getConexao();

	@Override
	public boolean inserir(Pet e) {

		String nome = e.getNome();
		String tipo = e.getTipo();
		String raca = e.getRaca();
		String cor = e.getCor();
		LocalDate datanascimento = e.getDatanascimento();
		int idDono = e.getDono().getId();

		String sql = "INSERT INTO PET (NOME, TIPO, RACA, COR, DATANASCIMENTO, IDDONO) VALUES (?,?,?,?,?,?)";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, nome);
			pstmt.setString(2, tipo);
			pstmt.setString(3, raca);
			pstmt.setString(4, cor);
			pstmt.setObject(5, datanascimento);
			pstmt.setInt(6, idDono);
			
			int res = pstmt.executeUpdate();
			
			System.out.println("\nPet "+nome+" inserido");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {

			System.out.println(ex);
		}
		return false;
	}

	@Override
	public boolean editar(Pet e) {

		int id = e.getId();
		String nome = e.getNome();
		String tipo = e.getTipo();
		String raca = e.getRaca();
		String cor = e.getCor();
		LocalDate datanascimento = e.getDatanascimento();
		int iddono = e.getDono().getId();

		String sql = "UPDATE PET SET NOME = ?, TIPO=?, RACA=?, COR=?, DATANASCIMENTO=?, IDDONO=? WHERE ID = ?";

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, nome);
			pstmt.setString(2, tipo);
			pstmt.setString(3, raca);
			pstmt.setString(4, cor);
			pstmt.setObject(5, datanascimento);
			pstmt.setInt(6, iddono);
			pstmt.setInt(7, id);

			int res = pstmt.executeUpdate(); // retorna a quantidade de registros inseridos

			System.out.println("Pet: "+nome+" editado!");
			
			if (res == 1)
				return true;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return false;

	}

	@Override
	public boolean excluir(int id) {
		
		String sql = "DELETE FROM PET WHERE ID = " + id;
		
		try (Statement stmt = con.createStatement();) {

			String nome = pesquisar(id).getNome();
			boolean res = stmt.execute(sql); // retorna a quantidade de registros inseridos
			System.out.println("Pet: "+nome+" excluido!");
			return res;

		} catch (SQLException ex) {
			System.out.println(ex);
		}
		
		return false;
	}

	@Override
	public Pet pesquisar(int id) {
		Pet p = new Pet();
		try {
			
			String sql = "SELECT * FROM PET WHERE ID = "+id;
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	        rs.next();
	        
	        String nome = rs.getString("nome");
	        String tipo = rs.getString("tipo");
	        String raca = rs.getString("raca");
	        String cor = rs.getString("cor");
	        String datanascimento = rs.getString("datanascimento");
	        int iddono = rs.getInt("iddono");
	        
	        p = new Pet(nome, tipo, raca, cor, datanascimento, Util.DBdateFormatter, new ClienteDAO().pesquisar(iddono), id);
	        
			
		} catch (SQLException ex) {
			System.out.println(ex);
		}
        
		System.out.println();
		return p;
	}

	@Override
	public List<Pet> listar() {
		List<Pet> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM PET";
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String nome = rs.getString("nome");
		        String tipo = rs.getString("tipo");
		        String raca = rs.getString("raca");
		        String cor = rs.getString("cor");
		        String datanascimento = rs.getString("datanascimento");
		        int iddono = rs.getInt("iddono");
		        int id = rs.getInt("id");
		        
		        Pet p = new Pet(nome, tipo, raca, cor, datanascimento, Util.DBdateFormatter, new ClienteDAO().pesquisar(iddono), id);
		        lista.add(p);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return lista;
	}

}
