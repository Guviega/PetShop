package pet.dao;

import dao.ClienteDAO;
import dao.PetDAO;
import model.Pet;

public class TestaInserirPet {

	public static void main(String[] args) {

		PetDAO dao = new PetDAO();
		ClienteDAO cdao = new ClienteDAO();
		
		Pet pet = new Pet("Lady", "Cachorro", "Pinscher", "Marrom", "19/12/2008", util.Util.dateFormatter, cdao.pesquisar(8));

		dao.inserir(pet);
	}

}
