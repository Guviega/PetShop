package cliente.dao;

import dao.ClienteDAO;
import model.Endereco;
import model.Pessoa;
import util.Util;

public class TestaInserirCliente {

	public static void main(String[] args) {

		ClienteDAO dao = new ClienteDAO();
		Endereco clienteEndereco = new Endereco("Siqueira Campos", 1721, "Tirolesa", "Tramandaí", "95590-000");
		Pessoa cliente = new Pessoa("Gustavo Viega I", "05173805013", "51999076062", 'M', "23/12/2004", Util.dateFormatter, clienteEndereco);
		dao.inserir(cliente);
	}

}
