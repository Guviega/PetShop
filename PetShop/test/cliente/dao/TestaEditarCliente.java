package cliente.dao;

import dao.ClienteDAO;
import model.Endereco;
import model.Pessoa;
import util.Util;

public class TestaEditarCliente {
	
	public static void main(String[] args) {
		
		ClienteDAO dao = new ClienteDAO();
		
		Pessoa cliente = dao.pesquisar(6);
		
		cliente.setCelular("51912341234");
		cliente.setCpf("48272174677");
		cliente.setDataNascimento("22/01/2005");
		Endereco newEndereco = new Endereco("7 de Setembro", 1688, "Zona Nova", "Tramandaí", "95590-000");
		cliente.setEndereco(newEndereco);
		cliente.setGenero('F');
		cliente.setNome("Eduarda Reichow");
		
		dao.editar(cliente);
		
		
	}

}
