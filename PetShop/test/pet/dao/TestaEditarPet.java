package pet.dao;

import dao.ClienteDAO;
import dao.PetDAO;
import model.Pet;

public class TestaEditarPet {

	public static void main(String[] args) {
		PetDAO dao = new PetDAO();
		ClienteDAO cdao = new ClienteDAO();
		Pet pet = dao.pesquisar(1);
		pet.setNome("Bob");
		pet.setCor("Branco");
		pet.setDatanascimento("14/11/2014");
		pet.setRaca("Persa");
		pet.setTipo("Gato");
		
		dao.editar(pet);
		
	}

}
