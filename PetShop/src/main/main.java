package main;

import model.Endereco;
import persist.Conexao;

public class main {
	
	public static void main(String[] args) {
		
		Endereco ed = new Endereco("siqueira", 1721, "tirol", "tdai", "95590-000");
		
		String[] vet = ed.toString().split(" ");
		String rua = vet[2].split(",")[0];
		int numero = Integer.parseInt(vet[3]);
		String bairro = vet[5].split(",")[0];
		String cidade = vet[6];
		String cep = vet[8];
		
		ed = new Endereco(rua, numero, bairro, cidade, cep);
		System.out.println(ed);
	}
	

}
