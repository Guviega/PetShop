package funcionario.dao;

import dao.FuncionarioDAO;

public class TestaListarFuncionario {

	public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		
		System.out.println(dao.listar());

	}

}
