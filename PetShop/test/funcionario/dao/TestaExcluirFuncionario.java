package funcionario.dao;

import dao.FuncionarioDAO;

public class TestaExcluirFuncionario {

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.excluir(5);

	}

}
