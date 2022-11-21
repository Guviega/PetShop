package model;

import java.util.Objects;

public class Endereco {
	
	//attributes
	private String rua, bairro, cidade, cep;
	private int numero;
	
	//constructor
	
	public Endereco() {
		
	}
	
	public Endereco(String rua, int numero, String bairro, String cidade, String cep) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.cep = cep;
	}

	//getters and setters
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	//hashCode and equals
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, numero, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && numero == other.numero && Objects.equals(rua, other.rua);
	}
	
	//toString

	@Override
	public String toString() {
		return "Rua " + rua + ", " + numero + " - " + bairro + ", " + cidade + " - " + cep;
	}
	
	
	
	
	
	
	
	

}
