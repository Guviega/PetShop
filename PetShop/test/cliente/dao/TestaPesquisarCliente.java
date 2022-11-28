package cliente.dao;

import dao.ClienteDAO;

public class TestaPesquisarCliente {

	public static void main(String[] args) {

		ClienteDAO dao = new ClienteDAO();

		System.out.println(dao.pesquisar(6));

	}
}
