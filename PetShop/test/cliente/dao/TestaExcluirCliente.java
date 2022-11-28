package cliente.dao;

import dao.ClienteDAO;

public class TestaExcluirCliente {

	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		
		dao.excluir(8);

	}

}
