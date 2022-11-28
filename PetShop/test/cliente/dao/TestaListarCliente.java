package cliente.dao;

import dao.ClienteDAO;

public class TestaListarCliente {

	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		
		System.out.println(dao.listar());

	}

}
