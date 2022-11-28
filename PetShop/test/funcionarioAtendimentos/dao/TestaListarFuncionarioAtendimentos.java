package funcionarioAtendimentos.dao;

import dao.view.FuncionarioAtendimentosDAO;

public class TestaListarFuncionarioAtendimentos {

	public static void main(String[] args) {

		FuncionarioAtendimentosDAO dao = new FuncionarioAtendimentosDAO();
		
		System.out.println(dao.listar());
		
	}

}
