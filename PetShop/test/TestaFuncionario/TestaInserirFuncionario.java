package TestaFuncionario;

import dao.FuncionarioDAO;
import model.Endereco;
import model.Funcionario;

public class TestaInserirFuncionario {
	
	public static void main(String[] args) {
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario func1 = new Funcionario("Olavo pereida", "05173805013", "51999076062", 'M', "23/12/2004", new Endereco("Rua Siqueira Campos", 1721, "Tirolesa", "Tramandaí", "95590000"), "olavo@gmail.com", 1200.00);
	
		dao.inserir(func1);
	}

}
