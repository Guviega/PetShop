package atendimento.dao;

import dao.AtendimentoDAO;
import model.Atendimento;

public class TestaEditarAtendimento {

	public static void main(String[] args) {

		AtendimentoDAO dao = new AtendimentoDAO();
		
		Atendimento a = dao.pesquisar(1);
		a.setData("19/10/2021");
		a.setDescricao("Vacina geral");
		a.setValor(150.0);
		
		dao.editar(a);
		
	}

}
