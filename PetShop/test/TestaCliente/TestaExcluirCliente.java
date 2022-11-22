package TestaCliente;
import dao.ClienteDAO;


public class TestaExcluirCliente {

	public static void main (String [] args) {
		
		ClienteDAO c1 = new ClienteDAO();
		c1.excluir(2);
		
	}
	
}
