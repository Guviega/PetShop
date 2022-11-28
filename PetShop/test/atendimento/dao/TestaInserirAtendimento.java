package atendimento.dao;

import dao.AtendimentoDAO;
import dao.FuncionarioDAO;
import dao.PetDAO;
import model.Atendimento;
import model.Funcionario;
import model.Pet;
import util.Util;

public class TestaInserirAtendimento {

	public static void main(String[] args) {

		AtendimentoDAO dao = new AtendimentoDAO();
		
		Pet pet = new PetDAO().pesquisar(1);
		Funcionario func = new FuncionarioDAO().pesquisar(2);
		Atendimento a = new Atendimento("Check-up", 80, "26/11/2022", Util.dateFormatter, pet, func);
		
		dao.inserir(a);
	}

}
