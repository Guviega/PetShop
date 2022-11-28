package pet.dao;

import dao.PetDAO;

public class TestaPesquisarPet {

	public static void main(String[] args) {

		PetDAO dao = new PetDAO();
		
		System.out.println(dao.pesquisar(1));

	}

}
