package atendimento.dao;

import dao.AtendimentoDAO;

public class TestaListarAtendimento {

	public static void main(String[] args) {

		AtendimentoDAO dao = new AtendimentoDAO();
		
		System.out.println(dao.listar());
		
	}

}
