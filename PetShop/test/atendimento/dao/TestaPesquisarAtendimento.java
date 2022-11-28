package atendimento.dao;

import dao.AtendimentoDAO;

public class TestaPesquisarAtendimento {

	public static void main(String[] args) {

		AtendimentoDAO dao = new AtendimentoDAO();
		
		System.out.println(dao.pesquisar(2));

	}

}
