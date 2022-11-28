package funcionario.dao;

import dao.FuncionarioDAO;
import model.Endereco;
import model.Funcionario;

public class TestaEditarFuncionario {
	
	public static void main(String[] args) {
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		Funcionario func = dao.pesquisar(2);
		
		func.setCelular("51912341234");
		func.setCpf("48272174677");
		func.setDataNascimento("22/01/2005");
		Endereco newEndereco = new Endereco("7 de Setembro", 1688, "Zona Nova", "Tramandai", "95590-000");
		func.setEndereco(newEndereco);
		func.setGenero('F');
		func.setNome("Eduarda Reichow");
		func.setEmail("dudareichow14@gmail.com");
		func.setSalario(2400.24);
		
		dao.editar(func);
		
	}

}
