package dao.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;
import model.view.FuncionarioAtendimentos;
import persist.Conexao;
import util.Util;

public class FuncionarioAtendimentosDAO {

	Connection con = Conexao.getConexao();
	
	public List<FuncionarioAtendimentos> listar() {
		List<FuncionarioAtendimentos> lista = new ArrayList<>();

		String sql = "SELECT * FROM \"FuncionarioAtendimentos\"";

		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String nome = rs.getString("Nome do funcionário");
				int numero = rs.getInt("Numero de atendimentos");
				double valor = rs.getInt("Valor total");

				FuncionarioAtendimentos p = new FuncionarioAtendimentos(nome, numero, valor);
				lista.add(p);
			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return lista;
	}

}
