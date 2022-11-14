package Util;

import java.time.format.DateTimeFormatter;

import model.Endereco;

public class Util {
	
	public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	
	public static Endereco parseEndereco(String endereco) {
		String[] vet = endereco.split(" ");
		String rua = vet[2].split(",")[0];
		int numero = Integer.parseInt(vet[3]);
		String bairro = vet[5].split(",")[0];
		String cidade = vet[6];
		String cep = vet[8];
		
		return new Endereco(rua, numero, bairro, cidade, cep);
	}

}
