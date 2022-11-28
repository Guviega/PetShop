package funcionario.dao;

import dao.FuncionarioDAO;

public class TestaPesquisarFuncionario {

	public static void main(String[] args) {

		FuncionarioDAO dao = new FuncionarioDAO();

		System.out.println(dao.pesquisar(1));

	}
}
