package TestaCliente;

import model.Endereco;
import model.Pessoa;
import dao.ClienteDAO;

public class TestaEditarCliente {
	
	public static void main(String[] args) {
		
		ClienteDAO cd = new ClienteDAO();
		Pessoa p = new Pessoa("Gustavo Viega", "05173805013", "51999076062", 'M', "23/12/2004", new Endereco("Siqueira Campos", 1721, "Tirolesa", "Tramandai", "95590000"), 5);
		cd.editar(p);
	}

}
