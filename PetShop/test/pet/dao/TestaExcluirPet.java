package pet.dao;

import dao.PetDAO;

public class TestaExcluirPet {

	public static void main(String[] args) {

		PetDAO dao = new PetDAO();
		
		dao.excluir(2);	
		
	}

}
