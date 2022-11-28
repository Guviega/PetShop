package funcionario.dao;

import dao.FuncionarioDAO;
import model.Endereco;
import model.Funcionario;
import util.Util;

public class TestaInserirFuncionario {

	public static void main(String[] args) {

		FuncionarioDAO dao = new FuncionarioDAO();
		Endereco funcEndereco = new Endereco("Siqueira Campos", 1721, "Tirolesa", "Tramandaí", "95590-000");
		Funcionario func = new Funcionario("Gustavo Viega I", "05173805013", "51999076062", 'M', "23/12/2004", Util.dateFormatter, funcEndereco, "guviega@gmail.com", 1200.12);
		dao.inserir(func);
	}

}
