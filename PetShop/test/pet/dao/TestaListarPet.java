package pet.dao;

import dao.PetDAO;

public class TestaListarPet {

	public static void main(String[] args) {

		PetDAO dao = new PetDAO();

		System.out.println(dao.listar());

	}

}
