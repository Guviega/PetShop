package atendimento.dao;

import dao.AtendimentoDAO;

public class TestaExcluirAtendimento {

	public static void main(String[] args) {

		AtendimentoDAO dao = new AtendimentoDAO();
		
		dao.excluir(2);
		
	}

}
