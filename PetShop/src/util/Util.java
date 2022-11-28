package util;

import java.time.format.DateTimeFormatter;

import model.Endereco;

public class Util {
	
	public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static DateTimeFormatter DBdateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	public static Endereco parseEndereco(String endereco) {
		String enderecoVetor[] = endereco.split(", ");
		String rua = enderecoVetor[0].split("Rua ")[1];
		int numero = Integer.parseInt(enderecoVetor[1].split(" -")[0]);
		String bairro = enderecoVetor[1].split("- ")[1];
		String cidade = enderecoVetor[2].split(" -")[0];
		String cep = enderecoVetor[2].split("- ")[1];
		
		return new Endereco(rua, numero, bairro, cidade, cep);
	}
}
