package TestaCliente;
import dao.ClienteDAO;
import model.Endereco;
import model.Pessoa;

public class TestaInserirCliente {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa("Gustavo V. I.", "05173805013", "51999076062", 'M', "23/12/2004", new Endereco("Siqueira Campos", 1721, "Tirolesa", "Tramandaí", "95590000"));
		
		ClienteDAO pd = new ClienteDAO();
		
		pd.inserir(p1);

	}

}
